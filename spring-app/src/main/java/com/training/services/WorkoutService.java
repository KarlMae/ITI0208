package com.training.services;

import com.training.dao.ExerciseMapper;
import com.training.dao.WorkoutMapper;
import com.training.dto.ExerciseDto;
import com.training.dto.ExerciseGroupDto;
import com.training.dto.WorkoutDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WorkoutService {

    private final WorkoutMapper workoutDao;
    private final ExerciseMapper exerciseDao;

    private void setExerciseWorkoutId(ExerciseDto exercise, WorkoutDto workout) {
        exercise.setWorkoutId(workout.getId());
    }

    private int setExerciseGroupId(ExerciseGroupDto group, WorkoutDto workout, int groupId) {
        for (ExerciseDto exercise : group.getSets()) {
            setExerciseWorkoutId(exercise, workout);
            exercise.setGroupId(groupId);
        }
        return groupId;
    }

    public int getLastExerciseGroupId() {
        return exerciseDao.getLastGroupId();
    }

    @Transactional
    public WorkoutDto insert(WorkoutDto dto) {
        workoutDao.insert(dto);
        int nextGroupId = getLastExerciseGroupId() + 1;

        for (ExerciseGroupDto group : dto.getExerciseGroups()) {
            nextGroupId = setExerciseGroupId(group, dto, nextGroupId) + 1;
        }

        List<ExerciseDto> exercises =  dto.getExerciseGroups()
                .stream()
                .flatMap(x -> x.getSets().stream())
                .collect(Collectors.toList());

        exerciseDao.bulkInsert(exercises);

        return dto;
    }

    @Transactional
    public WorkoutDto update(WorkoutDto dto) {
        exerciseDao.getLastGroupId();

        List<ExerciseDto> exercises =  dto.getExerciseGroups()
                .stream()
                .flatMap(x -> x.getSets().stream())
                .collect(Collectors.toList());

        workoutDao.update(dto);
        exerciseDao.bulkUpdate(exercises);

        return dto;
    }

    public List<WorkoutDto> fetchAll() {
        List<WorkoutDto> workouts = workoutDao.fetchAll();
        workouts.forEach(workoutDto -> workoutDto.setExercises(exerciseDao.fetchByWorkoutId(workoutDto.getId())));

        return workouts;
    }

    public WorkoutDto fetchById(Integer id) {
        WorkoutDto workoutDto = workoutDao.fetchById(id);
        List<ExerciseDto> exercises = exerciseDao.fetchByWorkoutId(workoutDto.getId());

        Map<Integer, List<ExerciseDto>> grouped =  exercises.stream().collect(Collectors.groupingBy(ExerciseDto::getGroupId));

        for (List<ExerciseDto> groupedExercises: grouped.values()) {
            workoutDto.addExerciseGroup(ExerciseGroupDto.createExerciseGroupDto(groupedExercises));
        }

        return workoutDto;
    }

}

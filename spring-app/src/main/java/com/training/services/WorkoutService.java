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

    @Transactional
    public WorkoutDto insert(WorkoutDto dto) {
        workoutDao.insert(dto);

        insertExercises(dto);

        return dto;
    }

    @Transactional
    public WorkoutDto update(WorkoutDto dto) {
        workoutDao.update(dto);
        exerciseDao.deleteOldExercises(dto.getId());

        insertExercises(dto);

        return dto;
    }

    private void insertExercises(WorkoutDto dto) {
        List<ExerciseDto> exercises = prepareExercisesForInsert(dto);
        exerciseDao.bulkInsert(exercises);
    }

    private List<ExerciseDto> prepareExercisesForInsert(WorkoutDto dto) {
        Integer lastGroupId = exerciseDao.getLastGroupId();

        for (ExerciseGroupDto group : dto.getExerciseGroups()) {
            lastGroupId += 1;
            for (ExerciseDto exercise : group.getSets()) {
                exercise.setGroupId(lastGroupId);
                exercise.setWorkoutId(dto.getId());
            }
        }

        return dto.getExerciseGroups()
                .stream()
                .flatMap(workoutDto -> workoutDto.getSets().stream())
                .collect(Collectors.toList());
    }

    public List<WorkoutDto> fetchAll() {
        List<WorkoutDto> workouts = workoutDao.fetchAll();
        workouts.forEach(workoutDto -> workoutDto.setExercises(exerciseDao.fetchByWorkoutId(workoutDto.getId())));

        return workouts;
    }

    public WorkoutDto fetchById(Integer id) {
        WorkoutDto workoutDto = workoutDao.fetchById(id);
        List<ExerciseDto> exercises = exerciseDao.fetchByWorkoutId(workoutDto.getId());

        Map<Integer, List<ExerciseDto>> grouped = exercises.stream().collect(Collectors.groupingBy(ExerciseDto::getGroupId));

        for (List<ExerciseDto> groupedExercises : grouped.values()) {
            workoutDto.addExerciseGroup(ExerciseGroupDto.createDto(groupedExercises));
        }

        return workoutDto;
    }

}

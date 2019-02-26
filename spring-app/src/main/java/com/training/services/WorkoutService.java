package com.training.services;

import com.training.dao.ExerciseMapper;
import com.training.dao.WorkoutMapper;
import com.training.dto.WorkoutDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WorkoutService {

    private final WorkoutMapper workoutDao;
    private final ExerciseMapper exerciseDao;


    public void insert(WorkoutDto dto) {
        workoutDao.insert(dto);
    }

    public List<WorkoutDto> fetchAll() {
        List<WorkoutDto> workouts = workoutDao.fetchAll();
        workouts.forEach(workoutDto -> workoutDto.setExercises(exerciseDao.fetchByWorkoutId(workoutDto.getId())));

        return workouts;
    }

    public WorkoutDto fetchById(Integer id) {
        WorkoutDto workoutDto = workoutDao.fetchById(id);
        workoutDto.setExercises(exerciseDao.fetchByWorkoutId(workoutDto.getId()));

        return workoutDto;
    }
}

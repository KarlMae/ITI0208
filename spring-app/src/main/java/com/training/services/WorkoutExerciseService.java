package com.training.services;

import com.training.dao.WorkoutExerciseMapper;
import com.training.dto.WorkoutExerciseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WorkoutExerciseService {

    private final WorkoutExerciseMapper exerciseDao;

    public void updateWithWeight(WorkoutExerciseDto dto) {
        exerciseDao.updateWithWeight(dto);
    }

    public void updateWithDuration(WorkoutExerciseDto dto) {
        exerciseDao.updateWithDuration(dto);
    }

}

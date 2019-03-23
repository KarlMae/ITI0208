package com.training.services;

import com.training.dao.ExerciseMapper;
import com.training.dto.ExerciseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExerciseService {

    private final ExerciseMapper exerciseDao;

    public void update(ExerciseDto dto) {
        exerciseDao.update(dto);
    }

}

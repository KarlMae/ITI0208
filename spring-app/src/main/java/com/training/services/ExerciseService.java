package com.training.services;

import com.training.dao.ExerciseMapper;
import com.training.dto.ExerciseDto;
import com.training.dto.ExerciseGroupDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExerciseService {

    private final ExerciseMapper exerciseDao;

    public ExerciseGroupDto fetchGroup(int id) {
        List<ExerciseDto> exercises = exerciseDao.fetchGroup(id);

        return ExerciseGroupDto.createDto(exercises);
    }

    public List<ExerciseDto> fetchAll() {
        return exerciseDao.fetchAll();
    }

    public void update(ExerciseGroupDto dto) {
        dto.getSets().forEach(exerciseDao::update);
    }

}

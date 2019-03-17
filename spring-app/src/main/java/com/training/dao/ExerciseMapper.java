package com.training.dao;

import com.training.dto.ExerciseDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ExerciseMapper {

    void insertExercise(ExerciseDto dto);

    ExerciseDto fetchById(Integer id);

    List<ExerciseDto> fetchAll();
}

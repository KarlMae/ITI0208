package com.training.dao;

import com.training.dto.ExerciseDto;
import com.training.dto.WorkoutDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ExerciseMapper {

    void insertExercise();

    List<WorkoutDto> fetchAll();

    ExerciseDto insertTraining(WorkoutDto dto);
}

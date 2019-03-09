package com.training.dao;

import com.training.dto.WorkoutExerciseDto;
import com.training.dto.WorkoutDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ExerciseMapper {

    void insertExercise();

    List<WorkoutDto> fetchAll();

    WorkoutExerciseDto insertTraining(WorkoutDto dto);

    List<WorkoutExerciseDto> fetchByWorkoutId(Integer id);
}

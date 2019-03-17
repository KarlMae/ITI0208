package com.training.dao;

import com.training.dto.WorkoutExerciseDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WorkoutExerciseMapper {

    List<WorkoutExerciseDto> fetchByWorkoutId(Integer id);

    void updateWithWeight(WorkoutExerciseDto dto);

    void updateWithDuration(WorkoutExerciseDto dto);

}

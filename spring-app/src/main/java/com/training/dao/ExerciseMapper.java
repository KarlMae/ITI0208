package com.training.dao;

import com.training.dto.ExerciseDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ExerciseMapper {

    List<ExerciseDto> fetchByWorkoutId(Integer id);

    List<ExerciseDto> fetchGroup(Integer id);

    List<ExerciseDto> fetchAll();

    void update(ExerciseDto dto);

    void bulkUpdate(List<ExerciseDto> dto);

    void bulkInsert(List<ExerciseDto> dto);

    Integer getLastGroupId();

    void deleteOldExercises(Integer workoutId);

}

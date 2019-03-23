package com.training.dao;

import com.training.dto.ExerciseDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ExerciseMapper {

    List<ExerciseDto> fetchByWorkoutId(Integer id);

    void update(ExerciseDto dto);

    void insert(ExerciseDto dto);

}

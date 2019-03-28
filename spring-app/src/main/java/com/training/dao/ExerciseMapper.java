package com.training.dao;

import com.training.dto.ExerciseDto;
import com.training.dto.ExerciseGroupDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ExerciseMapper {

    List<ExerciseDto> fetchByWorkoutId(Integer id);

    List<ExerciseDto> fetchGroup(Integer id);

    void update(ExerciseDto dto);

    void bulkInsert(List<ExerciseDto> dto);

    int getLastGroupId();

}

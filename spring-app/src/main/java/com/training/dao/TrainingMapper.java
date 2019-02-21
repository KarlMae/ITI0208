package com.training.dao;

import com.training.dto.WorkoutDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TrainingMapper {

    List<WorkoutDto> fetchAll();

    void insertTraining(WorkoutDto dto);
}

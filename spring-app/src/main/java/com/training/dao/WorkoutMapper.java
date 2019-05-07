package com.training.dao;

import com.training.dto.WorkoutDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WorkoutMapper {

    void insert(WorkoutDto dto);

    List<WorkoutDto> fetchAll();

    WorkoutDto fetchById(Integer id);

    void update(WorkoutDto dto);

}

package com.training.dao;

import com.training.dto.UserDto;
import com.training.dto.WorkoutDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    void inserUsers();

    List<WorkoutDto> fetchAll();

    UserDto fetchById();

}

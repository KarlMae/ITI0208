package com.training.dao;

import com.training.dto.WorkoutDto;
import com.training.dto.user.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface UserMapper {

    void registerUser(UserDto user);

    List<WorkoutDto> fetchAllWorkouts();

    UserDto fetchById();

    Optional<UserDto> findByUsername(String username);
}

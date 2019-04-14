package com.training.dao;

import com.training.dto.user.User;
import com.training.dto.WorkoutDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface UserMapper {

    void saveUser();

    List<WorkoutDto> fetchAllWorkouts();

    User fetchById();

    Optional<User> findByUsername(String username);
}

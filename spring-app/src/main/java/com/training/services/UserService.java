package com.training.services;

import com.training.dao.UserMapper;
import com.training.dto.WorkoutDto;
import com.training.dto.user.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserMapper userDao;

    public void registerUser(UserDto user) {
        userDao.registerUser(user);
    }

    public Optional<UserDto> findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public List<WorkoutDto> fetchAllWorkouts() {
        return userDao.fetchAllWorkouts();
    }
}

package com.training.services;

import com.training.dao.UserMapper;
import com.training.dto.WorkoutDto;
import com.training.dto.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserMapper userDao;

    Optional<User> findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public List<WorkoutDto> fetchAllWorkouts() {
        return userDao.fetchAllWorkouts();
    }
}

package com.training.services;

import com.training.dao.UserMapper;
import com.training.dto.WorkoutDto;
import com.training.dto.user.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public Integer getId(String username) {
        return userDao.getId(username);
    }

    public List<WorkoutDto> fetchAll(Integer id) {
        return userDao.fetchAll(id);
    }
}

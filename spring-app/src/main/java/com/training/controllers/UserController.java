package com.training.controllers;

import com.training.dto.WorkoutDto;
import com.training.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/user/fetchAllWorkouts")
    public List<WorkoutDto> fetchAllWorkouts() {
        return userService.fetchAllWorkouts();
    }
}

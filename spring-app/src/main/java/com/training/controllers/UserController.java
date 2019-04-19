package com.training.controllers;

import com.training.dto.WorkoutDto;
import com.training.dto.user.ApplicationUser;
import com.training.dto.user.ApplicationUserRepository;
import com.training.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;
    private PasswordEncoder passwordEncoder;
    private ApplicationUserRepository applicationUserRepository;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/user/fetchAllWorkouts")
    public List<WorkoutDto> fetchAllWorkouts() {
        return userService.fetchAllWorkouts();
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody ApplicationUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);
    }
}

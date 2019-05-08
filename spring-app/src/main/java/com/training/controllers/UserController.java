package com.training.controllers;

import com.training.dto.user.UserDto;
import com.training.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;
    private PasswordEncoder passwordEncoder;

    @PostMapping("/sign-up")
    public void signUp(@RequestBody UserDto user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.registerUser(user);
    }

    @GetMapping("/getId/{username}")
    public Integer getId(@PathVariable(value="username") String username) {
        System.out.println();
        return userService.getId(username);
    }

    @GetMapping("/fetchAllWorkouts")
//    public List<WorkoutDto> fetchAllWorkouts() {
    public String fetchAllWorkouts() {
//        return userService.fetchAllWorkouts();
        return "success";
    }
}

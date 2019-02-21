package com.training.controllers;

import com.training.dto.WorkoutDto;
import com.training.services.WorkoutService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class Controller {

    private final WorkoutService workoutService;

    @GetMapping("/")
    public String index() {
        return "Spring into Vue integration successful! Testing";
    }

    @GetMapping("/fetchAll")
    public List<WorkoutDto> fetchAll() {
        return workoutService.fetchAll();
    }

    @PostMapping(path="insert", consumes = "application/json")
    public void insertTraining(@RequestBody WorkoutDto dto) {
        workoutService.insertTraining(dto);
    }
}

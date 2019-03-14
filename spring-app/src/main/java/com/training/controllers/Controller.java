package com.training.controllers;

import com.training.dto.WorkoutDto;
import com.training.services.WorkoutService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
public class Controller {

    private final WorkoutService workoutService;

    @PostMapping(path="/insert", consumes = "application/json")
    public void insertWorkout(@RequestBody WorkoutDto dto) {
        workoutService.insert(dto);
    }

    @CrossOrigin
    @GetMapping("/fetchAll")
    public List<WorkoutDto> fetchAll() {
        return workoutService.fetchAll();
    }

    @CrossOrigin
    @GetMapping("/fetchById/{id}")
    public WorkoutDto fetchById(@PathVariable(value="id") Integer id) {
        return workoutService.fetchById(id);
    }
}

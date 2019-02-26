package com.training.controllers;

import com.training.dto.ExerciseDto;
import com.training.dto.WorkoutDto;
import com.training.services.WorkoutService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class Controller {

    private final WorkoutService workoutService;

    @PostMapping(path="/insert", consumes = "application/json")
    public void insertWorkout(@RequestBody WorkoutDto dto) {
        workoutService.insert(dto);
    }

    @GetMapping("/fetchAll")
    public List<WorkoutDto> fetchAll() {
        return workoutService.fetchAll();
    }

    @GetMapping("/fetchById/{id}")
    public WorkoutDto fetchById(@PathVariable(value="id") Integer id) {
        return workoutService.fetchById(id);
    }
}

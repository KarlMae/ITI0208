package com.training.controllers;

import com.training.dto.WorkoutDto;
import com.training.services.WorkoutService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/workout")
public class WorkoutController {

    private final WorkoutService workoutService;

    @PostMapping(path = "/insert", consumes = "application/json")
    public ResponseEntity<WorkoutDto> insertWorkout(@RequestBody WorkoutDto dto) {
        return ResponseEntity.accepted().body(workoutService.insert(dto));
    }

    @PostMapping(path = "/update", consumes = "application/json")
    public ResponseEntity<WorkoutDto> updateWorkout(@RequestBody WorkoutDto dto) {
        return ResponseEntity.accepted().body(workoutService.update(dto));
    }

    @GetMapping("/fetchAll")
    public List<WorkoutDto> fetchAllWorkouts() {
        return workoutService.fetchAll();
    }


    @GetMapping("/fetchById/{id}")
    public WorkoutDto fetchWorkout(@PathVariable(value="id") Integer id) {
        return workoutService.fetchById(id);
    }
}

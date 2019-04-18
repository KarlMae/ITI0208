package com.training.controllers;

import com.training.dto.ExerciseDto;
import com.training.dto.ExerciseGroupDto;
import com.training.dto.WorkoutDto;
import com.training.services.ExerciseService;
import com.training.services.WorkoutService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class Controller {

    private final WorkoutService workoutService;
    private final ExerciseService exerciseService;

    @PostMapping(path = "/insert", consumes = "application/json")
    public ResponseEntity<WorkoutDto> insertWorkout(@RequestBody WorkoutDto dto) {
        return ResponseEntity.accepted().body(workoutService.insert(dto));
    }

    @PostMapping(path = "/updateWorkout", consumes = "application/json")
    public ResponseEntity<WorkoutDto> updateWorkout(@RequestBody WorkoutDto dto) {
        return ResponseEntity.accepted().body(workoutService.update(dto));
    }

    @GetMapping("/fetchAllWorkouts")
    public List<WorkoutDto> fetchAllWorkouts() {
        return workoutService.fetchAll();
    }

    @GetMapping("/fetchAllExercises")
    public List<ExerciseDto> fetchAllExercises() {
        return exerciseService.fetchAll();
    }

    @GetMapping("/fetchWorkout/{id}")
    public WorkoutDto fetchWorkout(@PathVariable(value="id") Integer id) {
        return workoutService.fetchById(id);
    }

    @GetMapping("/fetchGroup/{id}")
    public ExerciseGroupDto fetchExerciseGroup(@PathVariable(value="id") Integer id) {
        return exerciseService.fetchGroup(id);
    }

    @PostMapping(path = "/updateExercise", consumes = "application/json")
    public void updateExercise(@RequestBody ExerciseGroupDto dto) {
        exerciseService.update(dto);
    }


    @GetMapping("/fetchSecret")
    public String fetchSecret() {
        return "Extremely secret content.";
    }
}

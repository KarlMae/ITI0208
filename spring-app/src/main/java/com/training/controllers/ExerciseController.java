package com.training.controllers;

import com.training.dto.ExerciseDto;
import com.training.dto.ExerciseGroupDto;
import com.training.dto.WorkoutDto;
import com.training.services.ExerciseService;
import com.training.services.WorkoutService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/exercise")
public class ExerciseController {

    private final ExerciseService exerciseService;

    @GetMapping("/fetchAll")
    public List<ExerciseDto> fetchAllExercises() {
        return exerciseService.fetchAll();
    }

    @GetMapping("/fetchGroup/{id}")
    public ExerciseGroupDto fetchExerciseGroup(@PathVariable(value="id") Integer id) {
        return exerciseService.fetchGroup(id);
    }

    @PostMapping(path = "/update", consumes = "application/json")
    public void updateExercise(@RequestBody ExerciseGroupDto dto) {
        exerciseService.update(dto);
    }

}

package com.training.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class WorkoutDto {

    private int id;
    private String name;
    private String description;
    private List<ExerciseGroupDto> exerciseGroups = new ArrayList<>();
    private List<ExerciseDto> exercises;

    public void addExerciseGroup(ExerciseGroupDto group) {
        this.exerciseGroups.add(group);
    }
}

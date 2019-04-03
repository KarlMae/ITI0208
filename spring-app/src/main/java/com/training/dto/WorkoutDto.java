package com.training.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class WorkoutDto {

    private int id;
    private String name;
    private String description;
    private List<ExerciseGroupDto> exerciseGroups;
    private List<ExerciseDto> exercises;

    public void addExerciseGroup(ExerciseGroupDto group) {
        this.exerciseGroups.add(group);
    }
}

package com.training.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkoutDto {

    private int id;
    private String name;
    private String description;
    private List<ExerciseGroupDto> exerciseGroups = new ArrayList<>();

    public void addExerciseGroup(ExerciseGroupDto group) {
        this.exerciseGroups.add(group);
    }
}

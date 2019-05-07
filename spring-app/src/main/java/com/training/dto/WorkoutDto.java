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

    private Integer id;
    private String name;
    private String description;
    private String image;
    private List<ExerciseGroupDto> exerciseGroups = new ArrayList<>();
    private List<ExerciseDto> exercises;

    public void addExerciseGroup(ExerciseGroupDto group) {
        this.exerciseGroups.add(group);
    }
}

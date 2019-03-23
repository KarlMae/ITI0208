package com.training.dto;

import lombok.Data;

import java.util.List;

@Data
public class WorkoutDto {

    private int id;
    private String name;
    private String description;
    private List<ExerciseDto> exercises;

}

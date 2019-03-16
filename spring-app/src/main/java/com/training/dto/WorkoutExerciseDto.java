package com.training.dto;

import lombok.Data;

@Data
public class WorkoutExerciseDto {
    private int workout_id;
    private int repetitions;
    private int set_nr;
    private int id;
    private String name;
    private String category;
    private int weight;
}
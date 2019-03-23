package com.training.dto;

import lombok.Data;

@Data
public class ExerciseDto {

    private int id;
    private int workoutId;
    private String name;
    private String category;
    private int set;
    private int repetitions;
    private int weight;
    private int duration;

}
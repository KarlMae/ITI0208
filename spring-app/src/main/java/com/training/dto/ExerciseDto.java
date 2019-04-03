package com.training.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExerciseDto {

    private int id;
    private int groupId;
    private int workoutId;
    private String name;
    private String category;
    private int set;
    private int repetitions;
    private int weight;
    private int duration;
}
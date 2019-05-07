package com.training.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseDto {

    private Integer id;
    private Integer groupId;
    private Integer workoutId;
    private String name;
    private String category;
    private Integer set;
    private Integer repetitions;
    private Integer weight;
    private Integer duration;
}
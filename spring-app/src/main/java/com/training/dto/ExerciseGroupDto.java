package com.training.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ExerciseGroupDto {

    private String name;
    private String category;
    private List<ExerciseDto> sets;
    private int groupId;

    public static ExerciseGroupDto createExerciseGroupDto(List<ExerciseDto> sets) {
        return new ExerciseGroupDto(sets.get(0).getName(),
                                    sets.get(0).getCategory(),
                                    sets,
                                    sets.get(0).getGroupId());
    }
}

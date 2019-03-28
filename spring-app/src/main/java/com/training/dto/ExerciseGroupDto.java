package com.training.dto;

import lombok.Data;

import java.util.List;

@Data
public class ExerciseGroupDto {

    private String name;
    private String category;
    private List<ExerciseDto> sets;
    private int groupId;

    public ExerciseGroupDto(String name, String category, List<ExerciseDto> sets, int groupId) {
        this.name = name;
        this.category = category;
        this.sets = sets;
        this.groupId = groupId;
    }

    public static ExerciseGroupDto createExerciseGroupDto(List<ExerciseDto> sets) {
        return new ExerciseGroupDto(sets.get(0).getName(),
                                    sets.get(0).getCategory(),
                                    sets,
                                    sets.get(0).getGroupId());
    }
}

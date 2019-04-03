package com.training;

import com.training.dao.ExerciseMapper;
import com.training.dto.ExerciseDto;
import com.training.dto.ExerciseGroupDto;
import com.training.services.ExerciseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ExerciseServiceTests {

    @InjectMocks
    private ExerciseService exerciseService;

    @Mock
    private ExerciseMapper exerciseDao;

    @Test
    public void testGetExerciseGroup() {
        ExerciseDto exercise = new ExerciseDto(1, 1, 1, "Push up", "Warm-up", 1,
                                        10, 0, 0);
        ExerciseDto exercise2 = new ExerciseDto(2, 1, 1, "Push up", "Warm-up", 2,
                                         11, 0, 0);
        List<ExerciseDto> exercises = Arrays.asList(exercise, exercise2);
        when(exerciseDao.fetchGroup(1)).thenReturn(exercises);
        ExerciseGroupDto exerciseGroup = exerciseService.fetchGroup(1);
        verify(exerciseDao).fetchGroup(1);
        assertEquals(exerciseGroup.getGroupId(),1);
    }

    @Test
    public void testUpdateExercise() {
        ExerciseDto exercise = new ExerciseDto(1, 1, 1, "Push up", "Warm-up", 1,
                10, 0, 0);
        List<ExerciseDto> exercises = Collections.singletonList(exercise);
        ExerciseGroupDto exerciseGroupDto = ExerciseGroupDto.createExerciseGroupDto(exercises);
        exerciseService.update(exerciseGroupDto);
        verify(exerciseDao).update(exercise);
    }

}

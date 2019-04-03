package com.training;

import com.training.controllers.Controller;
import com.training.dto.ExerciseDto;
import com.training.dto.ExerciseGroupDto;
import com.training.dto.WorkoutDto;
import com.training.services.ExerciseService;
import com.training.services.WorkoutService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTests {

    @InjectMocks
    Controller controller;

    @Mock
    private WorkoutService workoutService;

    @Mock
    private ExerciseService exerciseService;

    @Test
    public void testAddWorkout() {
        WorkoutDto workout = new WorkoutDto(1, "Test", "Test", new ArrayList<>(), new ArrayList<>());
        controller.insertWorkout(workout);
        verify(workoutService).insert(workout);
    }

    @Test
    public void testGetAllWorkouts() {
        WorkoutDto workout = new WorkoutDto(1, "Test", "Test", new ArrayList<>(), new ArrayList<>());
        WorkoutDto workout2 = new WorkoutDto(2, "Test2", "Test2", new ArrayList<>(), new ArrayList<>());
        List<WorkoutDto> workoutDtos = Arrays.asList(workout, workout2);
        when(workoutService.fetchAll()).thenReturn(workoutDtos);
        List<WorkoutDto> workouts = controller.fetchAll();
        verify(workoutService).fetchAll();
        assertEquals(workouts.size(), 2);
    }

    @Test
    public void testGetWorkoutById() {
        WorkoutDto workoutDto = new WorkoutDto(1, "Test", "Test", new ArrayList<>(), new ArrayList<>());
        when(workoutService.fetchById(1)).thenReturn(workoutDto);
        WorkoutDto workout = controller.fetchWorkout(1);
        verify(workoutService).fetchById(1);
        assertEquals(workout.getId(), 1);
    }

    @Test
    public void testGetExerciseGroupById() {
        ExerciseGroupDto exerciseGroupDto = new ExerciseGroupDto("Push up", "Warm-up", new ArrayList<>(), 1);
        when(exerciseService.fetchGroup(1)).thenReturn(exerciseGroupDto);
        ExerciseGroupDto exerciseGroup = controller.fetchExerciseGroup(1);
        verify(exerciseService).fetchGroup(1);
        assertEquals(exerciseGroup.getGroupId(),1);
    }

    @Test
    public void testUpdateExercise() {
        ExerciseDto exercise = new ExerciseDto(1, 1, 1, "Push up", "Warm-up", 1,
                                        10, 0, 0);
        List<ExerciseDto> exercises = Collections.singletonList(exercise);
        ExerciseGroupDto exerciseGroupDto = ExerciseGroupDto.createExerciseGroupDto(exercises);
        controller.updateExercise(exerciseGroupDto);
        verify(exerciseService).update(exerciseGroupDto);
    }

}

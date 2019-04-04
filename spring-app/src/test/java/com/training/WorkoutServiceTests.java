package com.training;

import com.training.dao.ExerciseMapper;
import com.training.dao.WorkoutMapper;
import com.training.dto.WorkoutDto;
import com.training.services.WorkoutService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WorkoutServiceTests {

    @InjectMocks
    private WorkoutService workoutService;

    @Mock
    private WorkoutMapper workoutDao;

    @Mock
    private ExerciseMapper exerciseDao;

    @Test
    public void testAddWorkout() {
        WorkoutDto workout = new WorkoutDto(1, "Test", "Test", new ArrayList<>(), new ArrayList<>());
        workoutService.insert(workout);
        verify(workoutDao).insert(workout);
    }

    @Test
    public void testGetAllWorkouts() {
        WorkoutDto workout = new WorkoutDto(1, "Test", "Test", new ArrayList<>(), new ArrayList<>());
        WorkoutDto workout2 = new WorkoutDto(2, "Test2", "Test2", new ArrayList<>(), new ArrayList<>());
        List<WorkoutDto> workoutDtos = Arrays.asList(workout, workout2);
        when(workoutDao.fetchAll()).thenReturn(workoutDtos);
        List<WorkoutDto> workouts = workoutService.fetchAll();
        verify(workoutDao).fetchAll();
        assertEquals(workouts.size(), 2);
    }

    @Test
    public void testGetWorkoutById() {
        WorkoutDto workoutDto = new WorkoutDto(1, "Test", "Test", new ArrayList<>(), new ArrayList<>());
        when(workoutDao.fetchById(1)).thenReturn(workoutDto);
        WorkoutDto workout = workoutService.fetchById(1);
        verify(workoutDao).fetchById(1);
        assertEquals(workout.getId(), 1);
    }

}

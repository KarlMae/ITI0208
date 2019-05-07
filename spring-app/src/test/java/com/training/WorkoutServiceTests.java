package com.training;

import com.training.dao.ExerciseMapper;
import com.training.dao.WorkoutMapper;
import com.training.dto.ExerciseDto;
import com.training.dto.ExerciseGroupDto;
import com.training.dto.WorkoutDto;
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

import static com.training.dto.ExerciseGroupDto.createExerciseGroupDto;
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
    public void testAddWorkoutWithOneExerciseAndGetExerciseGroupId() {
        ExerciseDto exercise = new ExerciseDto(1, 1, 1, "Push up", "Warm-up",
                1, 10, 0, 0);
        List<ExerciseDto> exercises = Collections.singletonList(exercise);
        ExerciseGroupDto pushUpExerciseGroup = createExerciseGroupDto(Collections.singletonList(exercise));
        List<ExerciseGroupDto> exerciseGroupDtos = Collections.singletonList(pushUpExerciseGroup);
        WorkoutDto workout = new WorkoutDto(1, "Test", "Test", exerciseGroupDtos, exercises);

        when(workoutService.getLastExerciseGroupId()).thenReturn(0);
        int lastExerciseGroupId = workoutService.getLastExerciseGroupId();
        workoutService.insert(workout);
        verify(workoutDao).insert(workout);

        when(workoutDao.fetchById(1)).thenReturn(workout);
        List<ExerciseGroupDto> exerciseGroups = workoutService.fetchById(1).getExerciseGroups();
        assertEquals(exerciseGroups.get(0).getGroupId(), lastExerciseGroupId + 1);
    }

    @Test
    public void testAddWorkoutWithMultipleExercisesThenGetExerciseGroupIds() {
        ExerciseDto exercise = new ExerciseDto(1, 1, 1, "Push up", "Warm-up",
                1, 10, 0, 0);
        ExerciseDto exercise2_1 = new ExerciseDto(2, 2, 1, "Plank", "Warm-up",
                1, 0, 0, 60);
        ExerciseDto exercise2_2 = new ExerciseDto(3, 2, 1, "Plank", "Warm-up",
                1, 0, 0, 65);
        List<ExerciseDto> exercises = Arrays.asList(exercise, exercise2_1, exercise2_2);
        ExerciseGroupDto pushUpExerciseGroup = createExerciseGroupDto(Collections.singletonList(exercise));
        ExerciseGroupDto plankExerciseGroup = createExerciseGroupDto(Arrays.asList(exercise2_1, exercise2_2));
        List<ExerciseGroupDto> exerciseGroupDtos = Arrays.asList(pushUpExerciseGroup, plankExerciseGroup);
        WorkoutDto workoutDto = new WorkoutDto(1, "Test", "Test", exerciseGroupDtos, exercises);

        when(workoutService.getLastExerciseGroupId()).thenReturn(0);
        int lastExerciseGroupId = workoutService.getLastExerciseGroupId();
        workoutService.insert(workoutDto);
        verify(workoutDao).insert(workoutDto);

        when(workoutDao.fetchById(1)).thenReturn(workoutDto);
        WorkoutDto workout = workoutService.fetchById(1);
        List<ExerciseGroupDto> exerciseGroups = workout.getExerciseGroups();
        assertEquals(exerciseGroups.get(0).getGroupId(), lastExerciseGroupId + 1);

        when(workoutService.getLastExerciseGroupId()).thenReturn(1);
        lastExerciseGroupId = workoutService.getLastExerciseGroupId();
        assertEquals(exerciseGroups.get(1).getGroupId(), lastExerciseGroupId + 1);
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

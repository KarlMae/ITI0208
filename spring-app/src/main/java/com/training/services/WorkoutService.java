package com.training.services;

import com.training.dao.WorkoutMapper;
import com.training.dto.WorkoutDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutMapper dao;

    public List<WorkoutDto> fetchAll() {
        return dao.fetchAll();
    }

    public void insertTraining(WorkoutDto dto) {
        dao.insertWorkout(dto);
    }
}

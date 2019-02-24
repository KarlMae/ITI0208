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

    public void insert(WorkoutDto dto) {
        dao.insert(dto);
    }

    public List<WorkoutDto> fetchAll() {
        return dao.fetchAll();
    }

    public WorkoutDto fetchById(Integer id) {
        return dao.fetchById(id);
    }
}

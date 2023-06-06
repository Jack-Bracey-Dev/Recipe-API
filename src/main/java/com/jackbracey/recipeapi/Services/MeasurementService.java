package com.jackbracey.recipeapi.Services;

import com.jackbracey.recipeapi.Entities.MeasurementEntity;
import com.jackbracey.recipeapi.Repositories.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {

    @Autowired
    private MeasurementRepository measurementRepository;

    public List<MeasurementEntity> findAll() {
        return measurementRepository.findAll();
    }

    public Optional<MeasurementEntity> findMeasurementByName(String name) {
        return measurementRepository.findByNameIgnoreCase(name);
    }

    public Optional<MeasurementEntity> findMeasurementById(Integer id) {
        return measurementRepository.findById(id);
    }

    public MeasurementEntity save(MeasurementEntity measurement) {
        return measurementRepository.save(measurement);
    }

}

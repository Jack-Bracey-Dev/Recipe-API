package com.jackbracey.recipeapi.Services;

import com.jackbracey.recipeapi.Entities.MeasurementEntity;
import com.jackbracey.recipeapi.Repositories.MeasurementRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MeasurementService {

    @Autowired
    private MeasurementRepository measurementRepository;

    public List<MeasurementEntity> findAll() {
        return measurementRepository.findAll();
    }

    public MeasurementEntity findMeasurementByName(String name) {
        log.info("Finding measurement: " + name);
        List<MeasurementEntity> measurementEntities =
                measurementRepository.findByNameIgnoreCaseOrShortNameIgnoreCaseOrOtherNamesContainsIgnoreCase(name, name, name);
        if (measurementEntities.size() > 0) {
            Optional<MeasurementEntity> optional = measurementEntities
                    .stream()
                    .filter(measurement -> measurement.getName().equalsIgnoreCase(name)
                            || measurement.getShortName().equalsIgnoreCase(name)
                            || Arrays.stream(measurement.getOtherNames().split(",")).map(String::toLowerCase).toList().contains(name.toLowerCase()))
                    .findFirst();

            return optional.orElse(null);
        }
        return null;
    }

    public Optional<MeasurementEntity> findMeasurementById(Integer id) {
        return measurementRepository.findById(id);
    }

    public MeasurementEntity save(MeasurementEntity measurement) {
        return measurementRepository.save(measurement);
    }

}

package com.jackbracey.recipeapi.Services;

import com.jackbracey.recipeapi.Entities.MeasurementConversion.MeasurementConversionEntity;
import com.jackbracey.recipeapi.Entities.MeasurementEntity;
import com.jackbracey.recipeapi.POJOs.Measurement;
import com.jackbracey.recipeapi.Repositories.MeasurementConversionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasurementConversionService {

    @Autowired
    private MeasurementConversionRepository measurementConversionRepository;

    public List<MeasurementConversionEntity> getAll() {
        return measurementConversionRepository.findAll();
    }

    public MeasurementConversionEntity save(MeasurementConversionEntity entity) {
        return measurementConversionRepository.save(entity);
    }

    public MeasurementConversionEntity findMeasurementConversionByMeasurements(MeasurementEntity from,
                                                                               MeasurementEntity to) {
        return measurementConversionRepository.findByBeginningMetricAndTargetMetric(from.getId(), to.getId());
    }

}

package com.jackbracey.recipeapi.Repositories;

import com.jackbracey.recipeapi.Entities.MeasurementConversion.MeasurementConversionEntity;
import com.jackbracey.recipeapi.Entities.MeasurementConversion.MeasurementConversionPKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementConversionRepository extends JpaRepository<MeasurementConversionEntity, MeasurementConversionPKey> {
}

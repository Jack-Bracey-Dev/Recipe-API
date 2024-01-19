package com.jackbracey.recipeapi.Repositories;

import com.jackbracey.recipeapi.Entities.MeasurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MeasurementRepository extends JpaRepository<MeasurementEntity, Integer> {
    List<MeasurementEntity> findByNameIgnoreCaseOrShortNameIgnoreCaseOrOtherNamesContainsIgnoreCase(String name, String shortName, String otherNames);
    MeasurementEntity findByNameIgnoreCase(String name);

}


package com.jackbracey.recipeapi.Repositories;

import com.jackbracey.recipeapi.Entities.MeasurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MeasurementRepository extends JpaRepository<MeasurementEntity, Integer> {
    Optional<MeasurementEntity> findByNameIgnoreCase(String name);

}

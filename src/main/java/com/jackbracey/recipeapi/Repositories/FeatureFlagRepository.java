package com.jackbracey.recipeapi.Repositories;

import com.jackbracey.recipeapi.Entities.FeatureFlagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeatureFlagRepository extends JpaRepository<FeatureFlagEntity, String> {
    Optional<FeatureFlagEntity> findByNameIgnoreCase(String name);

}

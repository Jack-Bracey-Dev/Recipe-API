package com.jackbracey.recipeapi.Repositories;

import com.jackbracey.recipeapi.Entities.ApiKeyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ApiKeyRepository extends JpaRepository<ApiKeyEntity, Integer> {
    Optional<ApiKeyEntity> findByKey(UUID key);
}

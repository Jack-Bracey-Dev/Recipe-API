package com.jackbracey.recipeapi.Repositories;

import com.jackbracey.recipeapi.Entities.ApiKeyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ApiKeyRepository extends JpaRepository<ApiKeyEntity, Integer> {

    @Query("select a from api_keys a where UPPER(a.type) = 'ADMIN' order by a.id LIMIT 1")
    Optional<ApiKeyEntity> findFirstAdminAccount();

    Optional<ApiKeyEntity> findByKey(UUID key);

}

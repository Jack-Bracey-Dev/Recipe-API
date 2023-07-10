package com.jackbracey.recipeapi.Repositories;

import com.jackbracey.recipeapi.Entities.Permissions.ApiKeyPermissionEntity;
import com.jackbracey.recipeapi.Entities.Permissions.ApiKeyPermissionsPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiKeyPermissionRepository extends JpaRepository<ApiKeyPermissionEntity, ApiKeyPermissionsPk> {
    long deleteByApiKeyId(Integer apiKeyId);

}

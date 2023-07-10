package com.jackbracey.recipeapi.Services;

import com.jackbracey.recipeapi.Entities.Permissions.ApiKeyPermissionEntity;
import com.jackbracey.recipeapi.Entities.Permissions.ApiKeyPermissionsPk;
import com.jackbracey.recipeapi.Repositories.ApiKeyPermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApiKeyPermissionService {

    @Autowired
    private ApiKeyPermissionRepository apiKeyPermissionRepository;

    public ApiKeyPermissionEntity createApiKeyPermissionEntry(Integer apiKeyId, Integer permissionId) {
        return apiKeyPermissionRepository.save(new ApiKeyPermissionEntity(apiKeyId, permissionId));
    }

    public ApiKeyPermissionEntity createApiKeyPermissionEntry(ApiKeyPermissionEntity entity) {
        return apiKeyPermissionRepository.save(entity);
    }

    public Optional<ApiKeyPermissionEntity> findById(Integer apiKeyId, Integer permissionId) {
        return apiKeyPermissionRepository.findById(new ApiKeyPermissionsPk(apiKeyId, permissionId));
    }

    public long deletePermissionsByKeyId(Integer apiKeyId) {
        return apiKeyPermissionRepository.deleteByApiKeyId(apiKeyId);
    }

}

package com.jackbracey.recipeapi.Services;

import com.jackbracey.recipeapi.Entities.ApiKeyEntity;
import com.jackbracey.recipeapi.Entities.Permissions.ApiKeyPermissionEntity;
import com.jackbracey.recipeapi.POJOs.GenericKeyType;
import com.jackbracey.recipeapi.Repositories.ApiKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApiKeyService {

    @Autowired
    private ApiKeyRepository apiKeyRepository;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private ApiKeyPermissionService apiKeyPermissionService;

    public Optional<ApiKeyEntity> getApiKey(UUID key) {
        return apiKeyRepository.findByKey(key);
    }

    public ApiKeyEntity createApiKey(GenericKeyType type) throws Exception {
        ApiKeyEntity unsaved = ApiKeyEntity.createUnsavedKey(type, permissionService);
        ApiKeyEntity saved;
        List<ApiKeyPermissionEntity> unsavedApiKeyPermissionEntities = unsaved.getPermissions();

        if (unsavedApiKeyPermissionEntities.size() > 0) {
            unsaved.setPermissions(null);
            saved = apiKeyRepository.save(unsaved);

            saved.setPermissions(unsavedApiKeyPermissionEntities);
            ApiKeyEntity.fillOutPermissions(saved, apiKeyPermissionService);
        } else {
            saved = apiKeyRepository.save(unsaved);
        }

        return saved;
    }

    public void deleteApiKey(ApiKeyEntity entity) {
        // TODO
    }
}

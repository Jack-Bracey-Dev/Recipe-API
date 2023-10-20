package com.jackbracey.recipeapi;

import com.jackbracey.recipeapi.Entities.ApiKeyEntity;
import com.jackbracey.recipeapi.Entities.Permissions.PermissionEntity;
import com.jackbracey.recipeapi.POJOs.GenericKeyType;
import com.jackbracey.recipeapi.POJOs.Permissions;
import com.jackbracey.recipeapi.Services.ApiKeyPermissionService;
import com.jackbracey.recipeapi.Services.ApiKeyService;
import com.jackbracey.recipeapi.Services.PermissionService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/*
* Should run when the service is started, check if required values such as permissions exist
* in the database, if not add them, and allow for basic functionality to begin on the project.
*/


@Slf4j
@Component
public class RunOnStartup {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private ApiKeyService apiKeyService;

    @Autowired
    private ApiKeyPermissionService apiKeyPermissionService;

    @PostConstruct
    public void run() {
        initialisePermissions();
        ApiKeyEntity apiKeyEntity = initialiseFirstApiKey();
        if (apiKeyEntity == null)
            return;

        apiKeyEntity.setPermissions(apiKeyPermissionService, permissionService, GenericKeyType.ADMIN.getDefaultPermissions());
        apiKeyEntity = apiKeyService.save(apiKeyEntity);
        log.info("----------------------------------");
        log.info(String.format("Admin API Key Created: %s", apiKeyEntity.getKey()));
        log.info("Make note of this key. It will not show again.");
        log.info("----------------------------------");
    }

    public void initialisePermissions() {
        for (Permissions permission : Permissions.values()) {
            PermissionEntity found = permissionService.findPermission(permission.name());
            if (found == null)
                permissionService.savePermission(new PermissionEntity(permission.name()));
        }
    }

    public ApiKeyEntity initialiseFirstApiKey() {
        ApiKeyEntity found = apiKeyService.getFirstAdmin();
        if (found != null)
            return null;

        try {
            return apiKeyService.createApiKey(GenericKeyType.ADMIN);
        } catch (Exception e) {
            log.error("Error during initialiseFirstApiKey");
            return null;
        }
    }

}

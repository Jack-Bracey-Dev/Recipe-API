package com.jackbracey.recipeapi.Controllers;

import com.jackbracey.recipeapi.Entities.ApiKeyEntity;
import com.jackbracey.recipeapi.Entities.Permissions.PermissionEntity;
import com.jackbracey.recipeapi.Helpers.Response;
import com.jackbracey.recipeapi.POJOs.Permission;
import com.jackbracey.recipeapi.Services.ApiKeyPermissionService;
import com.jackbracey.recipeapi.Services.ApiKeyService;
import com.jackbracey.recipeapi.Services.PermissionService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/permission")
@SuppressWarnings("unused")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private ApiKeyPermissionService apiKeyPermissionService;

    @Autowired
    private ApiKeyService apiKeyService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    @PreAuthorize("hasAuthority('CREATE_PERMISSION')")
    public Response addPermission(@RequestBody List<Permission> permissions) {
        if (permissions == null || permissions.size() == 0)
            return new Response(null, 400, "Missing json body");

        return Response.Success(permissionService.savePermissions(Permission.convertListToEntities(permissions)));
    }

    @PostMapping(name = "assign", path = "assign")
    @PreAuthorize("hasAuthority('ASSIGN_PERMISSION')")
    public Response assignPermissions(@RequestBody List<String> permissions, @RequestParam(name = "apiKey") String apiKey) {
        if (permissions == null || permissions.size() == 0)
            return new Response(null, 400, "Missing json body");

        if (Strings.isBlank(apiKey))
            return new Response(null, 400, "Missing apiKey request parameter");

        Optional<ApiKeyEntity> optionalApiKeyEntity = apiKeyService.getApiKey(UUID.fromString(apiKey));
        if (optionalApiKeyEntity.isEmpty())
            return new Response(null, 400, "Failed to find api key");
        ApiKeyEntity apiKeyEntity = optionalApiKeyEntity.get();

        String builderStartingValue = "Failed to assign the following:";
        StringBuilder errorMessage = new StringBuilder(builderStartingValue);

        for (String permission : permissions) {
            PermissionEntity permissionEntity = permissionService.findPermission(permission);
            if (permissionEntity == null) {
                errorMessage.append(String.format("\n'%s'", permission));
                continue;
            }

            apiKeyPermissionService.createApiKeyPermissionEntry(apiKeyEntity.getId(), permissionEntity.getId());
        }
        if (errorMessage.toString().equals(builderStartingValue))
            return new Response(null, 206, errorMessage.toString());

        return Response.Success(null);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('GET_PERMISSION')")
    public Response getPermissions() {
        return Response.Success(permissionService.getAllPermissions());
    }

}

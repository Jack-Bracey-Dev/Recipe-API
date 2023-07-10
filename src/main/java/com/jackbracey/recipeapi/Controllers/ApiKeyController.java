package com.jackbracey.recipeapi.Controllers;

import com.jackbracey.recipeapi.Entities.ApiKeyEntity;
import com.jackbracey.recipeapi.Helpers.Response;
import com.jackbracey.recipeapi.POJOs.GenericKeyType;
import com.jackbracey.recipeapi.Services.ApiKeyPermissionService;
import com.jackbracey.recipeapi.Services.ApiKeyService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/keys")
public class ApiKeyController {

    @Autowired
    private ApiKeyService apiKeyService;

    @GetMapping
    @PreAuthorize("hasAuthority('GET_API_KEY')")
    public Response getApiKeyDetails(@RequestParam(name = "apiKey") String apiKey) {
        Optional<ApiKeyEntity> entity = apiKeyService.getApiKey(UUID.fromString(apiKey));
        if (entity.isEmpty())
            return new Response(null, 204, "Cannot find that api key");
        return Response.Success(entity.get());
    }

    @PostMapping(produces = "application/json")
    @PreAuthorize("hasAuthority('CREATE_API_KEY')")
    public Response createApiKey(@RequestParam(name = "type") String type) throws Exception {
        if (Strings.isBlank(type))
            return new Response(null, 400, "Missing type parameter");

        GenericKeyType genericKeyType = GenericKeyType.valueOf(type);
        ApiKeyEntity entity = apiKeyService.createApiKey(genericKeyType);
        return Response.Success(entity.getKey());
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('REMOVE_API_KEY')")
    public Response deleteApiKey(@RequestParam(name = "apiKey") String apiKey) {
        if (Strings.isEmpty(apiKey))
            return new Response(null, 400, "Missing apiKey request parameter");

        Optional<ApiKeyEntity> entity = apiKeyService.getApiKey(UUID.fromString(apiKey));
        if (entity.isEmpty())
            return new Response(null, 204, "Unable to find that API key");

        apiKeyService.deleteApiKey(entity.get());
        return Response.Success(null);
    }

}

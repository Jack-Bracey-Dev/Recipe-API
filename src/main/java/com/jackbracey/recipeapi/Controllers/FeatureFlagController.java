package com.jackbracey.recipeapi.Controllers;

import com.jackbracey.recipeapi.Entities.FeatureFlagEntity;
import com.jackbracey.recipeapi.Helpers.Response;
import com.jackbracey.recipeapi.POJOs.FeatureFlag;
import com.jackbracey.recipeapi.Repositories.FeatureFlagRepository;
import com.jackbracey.recipeapi.Services.FeatureFlagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/feature-flag")
public class FeatureFlagController {

    @Autowired
    private FeatureFlagService featureFlagService;

    @Autowired
    private FeatureFlagRepository featureFlagRepository;

    @GetMapping
    @PreAuthorize("hasAuthority('GET_FEATURE_FLAG')")
    public Response getFeatureFlag(@RequestParam(name = "flag") String name) {
        Optional<FeatureFlagEntity> entity = featureFlagRepository.findByNameIgnoreCase(name);
        if (entity.isEmpty())
            return new Response(null, 204, "No feature flag by that name");

        return Response.Success(entity.get());
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @PreAuthorize("hasAuthority('CREATE_FEATURE_FLAG') or hasAuthority('UPDATE_FEATURE_FLAG')")
    public Response createOrUpdateFeatureFlag(@RequestBody FeatureFlag featureFlag) throws Exception {
        FeatureFlagEntity entity = featureFlag.convertToEntity();
        return Response.Success(featureFlagService.save(entity));
    }

}

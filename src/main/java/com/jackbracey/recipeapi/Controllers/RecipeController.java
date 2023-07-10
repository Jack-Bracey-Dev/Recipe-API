package com.jackbracey.recipeapi.Controllers;

import com.jackbracey.recipeapi.Entities.RecipeEntity;
import com.jackbracey.recipeapi.POJOs.Recipe;
import com.jackbracey.recipeapi.POJOs.RecipeFilter;
import com.jackbracey.recipeapi.Helpers.Response;
import com.jackbracey.recipeapi.Services.MeasurementService;
import com.jackbracey.recipeapi.Services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/recipe")
@SuppressWarnings("unused")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private MeasurementService measurementService;

    @PreAuthorize("hasAuthority('GET_RECIPE')")
    @GetMapping(consumes = "application/json", produces = "application/json")
    public Response getRecipesByFilter(@RequestBody RecipeFilter filter) {
        if (filter == null)
            return new Response(null, 400, "Missing request filter body");

        Response response = filter.checkForMisconfiguration();
        if (response.getCode() != 200)
            return response;

        return Response.Success(RecipeEntity.convertToPOJOs(recipeService.findRecipesByFilter(filter)));
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @PreAuthorize("hasAuthority('CREATE_RECIPE')")
    public Response create(@RequestBody Recipe recipe) {
        RecipeEntity recipeEntity = recipeService.save(recipe.convertToEntity(measurementService));
        return Response.Success(recipeEntity.convertToPOJO());
    }

    @DeleteMapping(produces = "application/json")
    @PreAuthorize("hasAuthority('DELETE_RECIPE')")
    public Response delete(@RequestParam Integer recipeId) {
        if (recipeId == null)
            return new Response(null, 400, "Missing recipeId parameter");

        boolean success = recipeService.remove(recipeId);

        if (success)
            return Response.Success(null, String.format("Recipe ID: %s successfully deleted", recipeId));
        return new Response(null, 204, String.format("Recipe ID: %s could not be found", recipeId));
    }

}

package com.jackbracey.recipeapi.DevTools.Controllers;


import com.jackbracey.recipeapi.DevTools.Helpers.DevRecipeHelper;
import com.jackbracey.recipeapi.Entities.RecipeEntity;
import com.jackbracey.recipeapi.Helpers.Response;
import com.jackbracey.recipeapi.Services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@PreAuthorize("hasAuthority('DEV_TEST_ACCOUNT')")
@RestController
@RequestMapping("dev/recipe")
public class DevRecipeHelperController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping
    public Response getRequest() {
        return Response.Success("Hi");
    }

    @PostMapping(path = "create", name = "create")
    public Response createTestRecipes(@RequestParam(value = "amount", required = false, defaultValue = "1") Integer amount) {
        List<RecipeEntity> recipes = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            RecipeEntity recipe = DevRecipeHelper.getRandomRecipeEntity();
            recipes.add(recipeService.save(recipe));
        }

        return Response.Success(recipes);
    }

}

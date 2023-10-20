package com.jackbracey.recipeapi.DevTools.Helpers;

import com.jackbracey.recipeapi.DevTools.StaticData.DevStaticRecipeData;
import com.jackbracey.recipeapi.Entities.IngredientEntity;
import com.jackbracey.recipeapi.Entities.RecipeEntity;
import com.jackbracey.recipeapi.Helpers.RandomHelper;
import com.jackbracey.recipeapi.POJOs.Recipe;
import com.jackbracey.recipeapi.POJOs.Source;

import java.util.List;

public class DevRecipeHelper {

    public static Recipe getRandomRecipe() {
        return new Recipe(
                getRandomName(),
                Source.BBCGOODFOOD.toString(),
                "https://www.bbcgoodfood.com",
                RandomHelper.getRandomOptionFromList(
                        List.of(20, 30, 60, 90, 120, 240)
                ),
                RandomHelper.getRandomOptionFromList(
                        List.of(20, 30, 60, 90, 120, 240)
                ),
                RandomHelper.getRandomOptionFromList(
                        List.of("Easy", "Medium", "Hard")
                ),
                RandomHelper.getRandomNumber(15),
                "Generated from the dev tool.",
                RandomHelper.getRandomNumber(100, 2000),
                RandomHelper.getRandomNumber(100, 2000),
                RandomHelper.getRandomNumber(100, 2000),
                RandomHelper.getRandomNumber(100, 2000),
                RandomHelper.getRandomNumber(100, 2000),
                RandomHelper.getRandomNumber(100, 2000),
                RandomHelper.getRandomNumber(100, 2000),
                RandomHelper.getRandomNumber(100, 2000),
                null
        );
    }

    public static RecipeEntity getRandomRecipeEntity() {
        List<IngredientEntity> ingredients = getRandom

        return new RecipeEntity(
                getRandomName(),
                Source.BBCGOODFOOD.toString(),
                "https://www.bbcgoodfood.com",
                RandomHelper.getRandomOptionFromList(
                        List.of(20, 30, 60, 90, 120, 240)
                ),
                RandomHelper.getRandomOptionFromList(
                        List.of(20, 30, 60, 90, 120, 240)
                ),
                RandomHelper.getRandomOptionFromList(
                        List.of("Easy", "Medium", "Hard")
                ),
                RandomHelper.getRandomNumber(15),
                "Generated from the dev tool.",
                RandomHelper.getRandomNumber(100, 2000),
                RandomHelper.getRandomNumber(100, 2000),
                RandomHelper.getRandomNumber(100, 2000),
                RandomHelper.getRandomNumber(100, 2000),
                RandomHelper.getRandomNumber(100, 2000),
                RandomHelper.getRandomNumber(100, 2000),
                RandomHelper.getRandomNumber(100, 2000),
                RandomHelper.getRandomNumber(100, 2000),
                null
        );
    }

    private static String getRandomName() {
        return DevStaticRecipeData.RecipeNames.get(
                RandomHelper.getRandomNumber(
                        DevStaticRecipeData.RecipeNames.size()-1));
    }

}

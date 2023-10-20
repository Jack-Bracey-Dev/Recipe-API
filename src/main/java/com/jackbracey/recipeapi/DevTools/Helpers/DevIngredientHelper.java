package com.jackbracey.recipeapi.DevTools.Helpers;

import com.jackbracey.recipeapi.Entities.IngredientEntity;

import java.util.ArrayList;
import java.util.List;

public class DevIngredientHelper {

    public static IngredientEntity getRandomIngredient() {
        return new IngredientEntity();
    }

    public static List<IngredientEntity> getRandomIngredients(int amount) {
        List<IngredientEntity> ingredients = new ArrayList<>();

        for (int i = 0; i < amount; i++)
            ingredients.add(getRandomIngredient());
        
        return ingredients;
    }

}

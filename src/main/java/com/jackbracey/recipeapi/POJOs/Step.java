package com.jackbracey.recipeapi.POJOs;

import com.jackbracey.recipeapi.Entities.RecipeEntity;
import com.jackbracey.recipeapi.Entities.StepEntity;

import java.util.ArrayList;
import java.util.List;

public class Step {

    private Integer id;

    private Recipe recipe;

    private Integer stepNumber;

    private String stepText;

    public Step(Integer id, Recipe recipe, Integer stepNumber, String stepText) {
        this.id = id;
        this.recipe = recipe;
        this.stepNumber = stepNumber;
        this.stepText = stepText;
    }

    public Step(Recipe recipe, Integer stepNumber, String stepText) {
        this.recipe = recipe;
        this.stepNumber = stepNumber;
        this.stepText = stepText;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Integer getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(Integer stepNumber) {
        this.stepNumber = stepNumber;
    }

    public String getStepText() {
        return stepText;
    }

    public void setStepText(String stepText) {
        this.stepText = stepText;
    }

    public static List<StepEntity> convertToEntities(List<Step> steps, RecipeEntity recipe) {
        List<StepEntity> stepEntities = new ArrayList<>();
        for (Step step : steps)
            stepEntities.add(convertToEntity(step, recipe));
        return stepEntities;
    }

    public static StepEntity convertToEntity(Step step, RecipeEntity recipe) {
        return new StepEntity(step.id, recipe, step.stepNumber, step.stepText);
    }
}

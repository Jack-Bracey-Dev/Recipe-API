package com.jackbracey.recipeapi.POJOs;

import com.jackbracey.recipeapi.Entities.RecipeEntity;
import com.jackbracey.recipeapi.POJOs.Enums.ScrapingSource;
import com.jackbracey.recipeapi.Services.MeasurementService;
import jakarta.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Recipe {

    private Integer id;

    private String name;

    private ScrapingSource source;

    private String url;

    // Stored in minutes
    private Integer prepTime;

    // Stored in minutes
    private Integer cookTime;

    private String difficulty;

    private Integer serves;

    private String description;

    private Integer calories;

    private Double fat;

    private Double saturates;

    private Double carbs;

    private Double sugars;

    private Double fibre;

    private Double protein;

    private Double salt;

    private List<Ingredient> ingredients;

    private List<Step> steps;

    public Recipe(@Nullable Integer id,
                  @Nullable String name,
                  @Nullable ScrapingSource source,
                  @Nullable String url,
                  @Nullable Integer prepTime,
                  @Nullable Integer cookTime,
                  @Nullable String difficulty,
                  @Nullable Integer serves,
                  @Nullable String description,
                  @Nullable Integer calories,
                  @Nullable Double fat,
                  @Nullable Double saturates,
                  @Nullable Double carbs,
                  @Nullable Double sugars,
                  @Nullable Double fibre,
                  @Nullable Double protein,
                  @Nullable Double salt,
                  @Nullable List<Ingredient> ingredients,
                  @Nullable List<Step> steps) {
        this.id = id;
        this.name = name;
        this.source = source;
        this.url = url;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.difficulty = difficulty;
        this.serves = serves;
        this.description = description;
        this.calories = calories;
        this.fat = fat;
        this.saturates = saturates;
        this.carbs = carbs;
        this.sugars = sugars;
        this.fibre = fibre;
        this.protein = protein;
        this.salt = salt;
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public static List<RecipeEntity> convertToEntities(List<Recipe> recipes,
                                                       MeasurementService measurementService) {
        List<RecipeEntity> entities = new ArrayList<>();
        for (Recipe recipe : recipes)
            entities.add(recipe.convertToEntity(measurementService));
        return entities;
    }

    public RecipeEntity convertToEntity(MeasurementService measurementService) {
        RecipeEntity entity = new RecipeEntity();

        entity.setName(this.name);
        entity.setSource(this.source);
        entity.setUrl(this.url);
        entity.setPrepTime(this.prepTime);
        entity.setCookTime(this.cookTime);
        entity.setDifficulty(this.difficulty);
        entity.setServes(this.serves);
        entity.setDescription(this.description);
        entity.setCalories(this.calories);
        entity.setFat(this.fat);
        entity.setSaturates(this.saturates);
        entity.setCarbs(this.carbs);
        entity.setSugars(this.sugars);
        entity.setFibre(this.fibre);
        entity.setProtein(this.protein);
        entity.setSalt(this.salt);
        if (this.ingredients.size() > 0)
            entity.setIngredients(Ingredient.convertToEntities(ingredients, measurementService));
        if (this.steps.size() > 0)
            entity.setSteps(Step.convertToEntities(steps, entity));

        return entity;
    }

    public Recipe() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ScrapingSource getSource() {
        return source;
    }

    public void setSource(ScrapingSource source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getServes() {
        return serves;
    }

    public void setServes(Integer serves) {
        this.serves = serves;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Double getSaturates() {
        return saturates;
    }

    public void setSaturates(Double saturates) {
        this.saturates = saturates;
    }

    public Double getCarbs() {
        return carbs;
    }

    public void setCarbs(Double carbs) {
        this.carbs = carbs;
    }

    public Double getSugars() {
        return sugars;
    }

    public void setSugars(Double sugars) {
        this.sugars = sugars;
    }

    public Double getFibre() {
        return fibre;
    }

    public void setFibre(Double fibre) {
        this.fibre = fibre;
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public Double getSalt() {
        return salt;
    }

    public void setSalt(Double salt) {
        this.salt = salt;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        if (this.ingredients == null)
            this.ingredients = new ArrayList<>();
        this.ingredients.add(ingredient);
    }

    public void addIngredients(List<Ingredient> ingredients) {
        if (this.ingredients == null)
            this.ingredients = ingredients;
        else
            this.ingredients.addAll(ingredients);
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }
}

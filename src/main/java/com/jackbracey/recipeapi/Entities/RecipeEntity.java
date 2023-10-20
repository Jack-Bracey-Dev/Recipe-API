package com.jackbracey.recipeapi.Entities;

import com.jackbracey.recipeapi.POJOs.Recipe;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "recipe")
public class RecipeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String source;

    private String url;

    @Column(name = "prep_time")
    private Integer prepTime;

    @Column(name = "cook_time")
    private Integer cookTime;

    private String difficulty;

    private Integer serves;

    private String description;

    private Integer calories;

    private Integer fat;

    private Integer saturates;

    private Integer carbs;

    private Integer sugars;

    private Integer fibre;

    private Integer protein;

    private Integer salt;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<IngredientEntity> ingredients = new ArrayList<>();

    public List<IngredientEntity> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientEntity> ingredients) {
        this.ingredients = ingredients;
    }

    public RecipeEntity(String name,
                        @Nullable String source,
                        @Nullable String url,
                        @Nullable Integer prepTime,
                        @Nullable Integer cookTime,
                        @Nullable String difficulty,
                        @Nullable Integer serves,
                        @Nullable String description,
                        @Nullable Integer calories,
                        @Nullable Integer fat,
                        @Nullable Integer saturates,
                        @Nullable Integer carbs,
                        @Nullable Integer sugars,
                        @Nullable Integer fibre,
                        @Nullable Integer protein,
                        @Nullable Integer salt,
                        @Nullable List<IngredientEntity> ingredients) {
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
    }

    public RecipeEntity() {
    }

    public static List<Recipe> convertToPOJOs(List<RecipeEntity> entities) {
        List<Recipe> recipes = new ArrayList<>();
        for (RecipeEntity recipe : entities)
            recipes.add(recipe.convertToPOJO());
        return recipes;
    }

    public Recipe convertToPOJO() {
        Recipe recipe = new Recipe(
                this.id,
                this.name,
                this.source,
                this.url,
                this.prepTime,
                this.cookTime,
                this.difficulty,
                this.serves,
                this.description,
                this.calories,
                this.fat,
                this.saturates,
                this.carbs,
                this.sugars,
                this.fibre,
                this.protein,
                this.salt,
                null
        );
        recipe.setIngredients(IngredientEntity.convertToPOJOs(this.ingredients));
        return recipe;
    }

    public RecipeEntity(String name) {
        this.name = name;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
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

    public Integer getFat() {
        return fat;
    }

    public void setFat(Integer fat) {
        this.fat = fat;
    }

    public Integer getSaturates() {
        return saturates;
    }

    public void setSaturates(Integer saturates) {
        this.saturates = saturates;
    }

    public Integer getCarbs() {
        return carbs;
    }

    public void setCarbs(Integer carbs) {
        this.carbs = carbs;
    }

    public Integer getSugars() {
        return sugars;
    }

    public void setSugars(Integer sugars) {
        this.sugars = sugars;
    }

    public Integer getFibre() {
        return fibre;
    }

    public void setFibre(Integer fibre) {
        this.fibre = fibre;
    }

    public Integer getProtein() {
        return protein;
    }

    public void setProtein(Integer protein) {
        this.protein = protein;
    }

    public Integer getSalt() {
        return salt;
    }

    public void setSalt(Integer salt) {
        this.salt = salt;
    }
}

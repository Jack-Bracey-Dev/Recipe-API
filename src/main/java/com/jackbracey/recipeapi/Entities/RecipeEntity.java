package com.jackbracey.recipeapi.Entities;

import com.jackbracey.recipeapi.POJOs.Enums.ScrapingSource;
import com.jackbracey.recipeapi.POJOs.Recipe;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "recipe")
public class RecipeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "source")
    private ScrapingSource source;

    private String url;

    // Stored in minutes
    @Column(name = "prep_time")
    private Integer prepTime;

    // Stored in minutes
    @Column(name = "cook_time")
    private Integer cookTime;

    @Column(name = "extra_time")
    private Integer extraTime;

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

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<IngredientEntity> ingredients = new ArrayList<>();

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<StepEntity> steps;

    public List<IngredientEntity> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientEntity> ingredients) {
        this.ingredients = ingredients;
    }

    public RecipeEntity(String name,
                        @Nullable ScrapingSource source,
                        @Nullable String url,
                        @Nullable Integer prepTime,
                        @Nullable Integer cookTime,
                        @Nullable Integer extraTime,
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
                        @Nullable Double salt) {
        this.name = name;
        this.source = source;
        this.url = url;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.extraTime = extraTime;
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
                this.extraTime,
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
                null,
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

    public Integer getExtraTime() {
        return extraTime;
    }

    public void setExtraTime(Integer extraTime) {
        this.extraTime = extraTime;
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

    public List<StepEntity> getSteps() {
        return steps;
    }

    public void setSteps(List<StepEntity> steps) {
        this.steps = steps;
    }
}

package com.jackbracey.recipeapi.Entities;

import com.jackbracey.recipeapi.POJOs.Ingredient;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "ingredient")
public class IngredientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private BigDecimal amount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id", referencedColumnName = "id")
    private RecipeEntity recipe;

    @OneToOne
    @JoinColumn(name = "measurement_id")
    private MeasurementEntity measurement;

    public IngredientEntity(Integer id, String name, BigDecimal amount, RecipeEntity recipe, MeasurementEntity measurement) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.recipe = recipe;
        this.measurement = measurement;
    }

    public IngredientEntity() {
    }

    public static List<Ingredient> convertToPOJOs(List<IngredientEntity> ingredientEntities) {
        List<Ingredient> ingredients = new ArrayList<>();
        for (IngredientEntity ingredient : ingredientEntities)
            ingredients.add(ingredient.convertToPOJO());
        return ingredients;
    }

    public Ingredient convertToPOJO() {
        return new Ingredient(this.id, this.name, this.amount, this.measurement.convertToPOJO());
    }

    public MeasurementEntity getMeasurement() {
        return measurement;
    }

    public void setMeasurement(MeasurementEntity measurement) {
        this.measurement = measurement;
    }

    public RecipeEntity getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeEntity recipe) {
        this.recipe = recipe;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}

package com.jackbracey.recipeapi.Entities;

import com.jackbracey.recipeapi.POJOs.Ingredient;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "ingredient")
public class IngredientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;

    private Double amount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id", referencedColumnName = "id")
    private RecipeEntity recipe;

    @OneToOne
    @JoinColumn(name = "measurement_id")
    private MeasurementEntity measurement;

    @Column(name = "header")
    private String header;

    @Column(name = "optional")
    private Boolean optional;

    public IngredientEntity(Integer id,
                            String description,
                            Double amount,
                            RecipeEntity recipe,
                            MeasurementEntity measurement,
                            String header,
                            Boolean optional) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.recipe = recipe;
        this.measurement = measurement;
        this.header = header;
        this.optional = optional;
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
        return new Ingredient(
                this.id,
                this.description,
                this.amount,
                this.measurement != null ? this.measurement.convertToPOJO() : null,
                this.header);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Boolean getOptional() {
        return optional;
    }

    public void setOptional(Boolean optional) {
        this.optional = optional;
    }
}

package com.jackbracey.recipeapi.POJOs;

import com.jackbracey.recipeapi.Entities.IngredientEntity;
import com.jackbracey.recipeapi.Entities.MeasurementEntity;
import com.jackbracey.recipeapi.Services.MeasurementService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Ingredient {

    private Integer id;

    private String name;

    private BigDecimal amount;

    private String measurementName;

    private Measurement measurement;

    public Ingredient(Integer id, String name, BigDecimal amount, Measurement measurement) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.measurement = measurement;
        this.measurementName = measurement.getName();
    }

    public Ingredient(MeasurementService measurementService, Integer id, String name, BigDecimal amount, String measurementName) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.measurementName = measurementName;
        this.measurement = null;
    }

    public Ingredient() {
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

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public String getMeasurementName() {
        return measurementName;
    }

    public void setMeasurementName(String measurementName) {
        this.measurementName = measurementName;
    }

    public static List<IngredientEntity> convertToEntities(List<Ingredient> ingredients,
                                                           MeasurementService measurementService) {
        List<IngredientEntity> ingredientEntities = new ArrayList<>();
        for (Ingredient ingredient : ingredients)
            ingredientEntities.add(ingredient.convertToEntity(measurementService));
        return ingredientEntities;
    }

    public IngredientEntity convertToEntity(MeasurementService measurementService) {
        IngredientEntity ingredientEntity = new IngredientEntity();
        if (this.id != null)
            ingredientEntity.setId(this.id);
        ingredientEntity.setName(this.name);
        ingredientEntity.setAmount(this.amount);

        Optional<MeasurementEntity> measurementOptional = measurementService.findMeasurementByName(this.measurementName);
        MeasurementEntity measurement;
        if (measurementOptional.isEmpty())
            measurement = measurementService.save(new MeasurementEntity(this.measurementName));
        else
            measurement = measurementOptional.get();
        ingredientEntity.setMeasurement(measurement);

        return ingredientEntity;
    }

}

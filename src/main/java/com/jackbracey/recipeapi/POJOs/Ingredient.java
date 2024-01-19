package com.jackbracey.recipeapi.POJOs;

import com.jackbracey.recipeapi.Entities.IngredientEntity;
import com.jackbracey.recipeapi.Entities.MeasurementEntity;
import com.jackbracey.recipeapi.Services.MeasurementService;
import jakarta.annotation.Nullable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Ingredient {

    private Integer id;

    private String description;

    private Double amount;

    private String measurementName;

    private Measurement measurement;

    private String header;

    public Ingredient(Integer id,
                      String description,
                      Double amount,
                      @Nullable Measurement measurement,
                      String header) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.measurement = measurement;
        this.measurementName = measurement != null ? measurement.getName() : "";
        this.header = header;
    }

    // TODO: Implement grabbing the measurement
    public Ingredient(MeasurementService measurementService,
                      Integer id,
                      String description,
                      Double amount,
                      String measurementName) {
        this.id = id;
        this.description = description;
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

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
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
        ingredientEntity.setDescription(this.description);
        ingredientEntity.setAmount(this.amount);
        ingredientEntity.setHeader(this.header);

        MeasurementEntity measurement = measurementService.findMeasurementByName(this.measurementName);
//        if (measurement == null)
//            measurement = measurementService.save(new MeasurementEntity(this.measurementName));
        ingredientEntity.setMeasurement(measurement);

        return ingredientEntity;
    }

}

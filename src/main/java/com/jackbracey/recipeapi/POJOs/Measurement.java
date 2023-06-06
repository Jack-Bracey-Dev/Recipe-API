package com.jackbracey.recipeapi.POJOs;

import com.jackbracey.recipeapi.Entities.MeasurementEntity;

import java.util.ArrayList;
import java.util.List;

public class Measurement {

    private Integer id;

    private String name;

    private String shortName;

    private String otherNames;

    public Measurement(Integer id, String name, String shortName, String otherNames) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.otherNames = otherNames;
    }

    public static List<MeasurementEntity> convertToEntities(List<Measurement> measurements) {
        List<MeasurementEntity> entities = new ArrayList<>();
        for (Measurement measurement : measurements)
            entities.add(measurement.convertToEntity());
        return entities;
    }

    public MeasurementEntity convertToEntity() {
        return new MeasurementEntity(this.name, this.shortName, this.otherNames);
    }

    public Measurement() {
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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames;
    }
}

package com.jackbracey.recipeapi.POJOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jackbracey.recipeapi.Entities.FeatureFlagEntity;
import com.jackbracey.recipeapi.POJOs.Enums.FeatureFlagDataType;

import java.io.Serializable;

public class FeatureFlag implements Serializable {

    private String name;

    private String value;

    @JsonProperty("data_type")
    private String dataType;

    public FeatureFlag(String name, String value, String dataType) {
        this.name = name;
        this.value = value;
        this.dataType = dataType;
    }

    public FeatureFlag() {
    }

    public FeatureFlagEntity convertToEntity() throws Exception {
        FeatureFlagEntity entity = new FeatureFlagEntity();
        entity.setName(this.name);
        entity.setValue(this.value);
        entity.setDataType(FeatureFlagDataType.get(this.dataType));
        return entity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}

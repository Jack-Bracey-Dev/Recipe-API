package com.jackbracey.recipeapi.Entities;

import com.jackbracey.recipeapi.POJOs.Enums.FeatureFlagDataType;
import jakarta.persistence.*;

@Entity(name = "feature_flag")
public class FeatureFlagEntity {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private String value;

    @Column(name = "data_type")
    @Enumerated(EnumType.STRING)
    private FeatureFlagDataType dataType;

    public FeatureFlagEntity(String name, String value, FeatureFlagDataType dataType) {
        this.name = name;
        this.value = value;
        this.dataType = dataType;
    }

    public FeatureFlagEntity() {
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

    public FeatureFlagDataType getDataType() {
        return dataType;
    }

    public void setDataType(FeatureFlagDataType dataType) {
        this.dataType = dataType;
    }
}

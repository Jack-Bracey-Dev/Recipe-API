package com.jackbracey.recipeapi.Entities;

import com.jackbracey.recipeapi.POJOs.Measurement;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "measurement")
public class MeasurementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "short_name", unique = true)
    private String shortName;

    @Column(name = "other_names")
    private String otherNames;

    public MeasurementEntity(String name, String shortName, String otherNames) {
        this.name = name;
        this.shortName = shortName;
        this.otherNames = otherNames;
    }

    public MeasurementEntity(String name) {
        this.name = name;
    }

    public MeasurementEntity() {
    }

    public static List<Measurement> convertToPOJOs(List<MeasurementEntity> measurementEntities) {
        List<Measurement> measurements = new ArrayList<>();
        for (MeasurementEntity measurement : measurementEntities)
            measurements.add(measurement.convertToPOJO());
        return measurements;
    }

    public Measurement convertToPOJO() {
        return new Measurement(this.id, this.name, this.shortName, this.otherNames);
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

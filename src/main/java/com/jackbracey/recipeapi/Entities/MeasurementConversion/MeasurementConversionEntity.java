package com.jackbracey.recipeapi.Entities.MeasurementConversion;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "measurement_conversions")
@IdClass(MeasurementConversionPKey.class)
public class MeasurementConversionEntity {

    @Id
    @Column(name = "beginning_metric")
    private Integer beginningMetric;

    @Id
    @Column(name = "target_metric")
    private Integer targetMetric;

    private Double multiplier;

    public MeasurementConversionEntity(Integer beginningMetric, Integer targetMetric, Double multiplier) {
        this.beginningMetric = beginningMetric;
        this.targetMetric = targetMetric;
        this.multiplier = multiplier;
    }

    public MeasurementConversionEntity() {
    }

    public Integer getBeginningMetric() {
        return beginningMetric;
    }

    public void setBeginningMetric(Integer beginningMetric) {
        this.beginningMetric = beginningMetric;
    }

    public Integer getTargetMetric() {
        return targetMetric;
    }

    public void setTargetMetric(Integer targetMetric) {
        this.targetMetric = targetMetric;
    }

    public Double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(Double multiplier) {
        this.multiplier = multiplier;
    }
}

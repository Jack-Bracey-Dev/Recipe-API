package com.jackbracey.recipeapi.Entities.MeasurementConversion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

import java.math.BigDecimal;

@Entity(name = "measurement_conversions")
@IdClass(MeasurementConversionPKey.class)
public class MeasurementConversionEntity {

    @Id
    @Column(name = "beginning_metric")
    private String beginningMetric;

    @Id
    @Column(name = "target_metric")
    private String targetMetric;

    private BigDecimal multiplier;

    public MeasurementConversionEntity(String beginningMetric, String targetMetric, BigDecimal multiplier) {
        this.beginningMetric = beginningMetric;
        this.targetMetric = targetMetric;
        this.multiplier = multiplier;
    }

    public MeasurementConversionEntity() {
    }

    public String getBeginningMetric() {
        return beginningMetric;
    }

    public void setBeginningMetric(String beginningMetric) {
        this.beginningMetric = beginningMetric;
    }

    public String getTargetMetric() {
        return targetMetric;
    }

    public void setTargetMetric(String targetMetric) {
        this.targetMetric = targetMetric;
    }

    public BigDecimal getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(BigDecimal multiplier) {
        this.multiplier = multiplier;
    }
}

package com.jackbracey.recipeapi.Entities.MeasurementConversion;

import java.io.Serializable;

public class MeasurementConversionPKey implements Serializable {

    private Integer beginningMetric;

    private Integer targetMetric;

    public MeasurementConversionPKey(Integer beginningMetric, Integer targetMetric) {
        this.beginningMetric = beginningMetric;
        this.targetMetric = targetMetric;
    }

    public MeasurementConversionPKey() {
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
}

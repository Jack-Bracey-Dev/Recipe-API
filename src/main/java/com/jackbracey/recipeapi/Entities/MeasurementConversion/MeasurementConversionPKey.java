package com.jackbracey.recipeapi.Entities.MeasurementConversion;

import java.io.Serializable;

public class MeasurementConversionPKey implements Serializable {

    private String beginningMetric;

    private String targetMetric;

    public MeasurementConversionPKey(String beginningMetric, String targetMetric) {
        this.beginningMetric = beginningMetric;
        this.targetMetric = targetMetric;
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
}

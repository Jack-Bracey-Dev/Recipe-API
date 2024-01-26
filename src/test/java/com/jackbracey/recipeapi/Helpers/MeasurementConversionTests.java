package com.jackbracey.recipeapi.Helpers;

import com.jackbracey.recipeapi.Entities.MeasurementConversion.MeasurementConversionEntity;
import com.jackbracey.recipeapi.Entities.MeasurementEntity;
import com.jackbracey.recipeapi.Services.MeasurementConversionService;
import com.jackbracey.recipeapi.Services.MeasurementService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MeasurementConversionTests {

    static MeasurementConversionService measurementConversionService;

    static MeasurementService measurementService;

    static MeasurementEntity kg, lbs;

    static MeasurementConversion measurementConversion;

    @BeforeAll
    public static void setup() {
        //MeasurementConversionService setup
        measurementConversionService = mock(MeasurementConversionService.class);

        kg = new MeasurementEntity("kg", "", "");
        kg.setId(1);

        lbs = new MeasurementEntity("lbs", "", "");
        lbs.setId(2);

        when(measurementConversionService.findMeasurementConversionByMeasurements(kg, lbs))
                .thenReturn(new MeasurementConversionEntity(kg.getId(), lbs.getId(), 2.205));

        // MeasurementService setup
        measurementService = mock(MeasurementService.class);

        when(measurementService.findMeasurementByName("kg")).thenReturn(kg);
        when(measurementService.findMeasurementByName("lbs")).thenReturn(lbs);

        measurementConversion = new MeasurementConversion(
                measurementService, measurementConversionService);
    }

    @Test
    void shouldReturnCorrectConvertedValue_providedMeasurementEntities_multiplication_1() {
        Assertions.assertEquals(264.6, measurementConversion.convertMeasurement(120.0, kg, lbs));
    }

    @Test
    void shouldReturnCorrectConvertedValue_providedMeasurementEntities_division_1() {
        Assertions.assertEquals(4.54, measurementConversion.convertMeasurement(10.0, lbs, kg));
    }

    @Test
    void shouldReturnCorrectConvertedValue_providedStringMeasurement_multiplication_1() {
        Assertions.assertEquals(264.6, measurementConversion.convertMeasurement(120.0, "kg", "lbs"));
    }

    @Test
    void shouldReturnCorrectConvertedValue_providedStringMeasurement_division_1() {
        Assertions.assertEquals(4.54, measurementConversion.convertMeasurement(10.0, "lbs", "kg"));
    }

}

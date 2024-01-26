package com.jackbracey.recipeapi.Helpers;

import com.jackbracey.recipeapi.Entities.MeasurementConversion.MeasurementConversionEntity;
import com.jackbracey.recipeapi.Entities.MeasurementEntity;
import com.jackbracey.recipeapi.Services.MeasurementConversionService;
import com.jackbracey.recipeapi.Services.MeasurementService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;

@Slf4j
public class MeasurementConversion {

    private MeasurementService measurementService;

    private MeasurementConversionService measurementConversionService;

    public MeasurementConversion(MeasurementService measurementService,
                                 MeasurementConversionService measurementConversionService) {
        this.measurementService = measurementService;
        this.measurementConversionService = measurementConversionService;
    }

    /***
     * @param fromAmount The value of the measurement you want to convert
     * @param from The measurement you're converting from
     * @param to The measurement you're converting to
     * @return The result of the conversion rounded to 2 decimal places
     */
    public Double convertMeasurement(Double fromAmount,
                                     MeasurementEntity from,
                                     MeasurementEntity to) {
        String error = checkForNullValues(fromAmount, from, to);
        if (Strings.isNotBlank(error)) {
            log.error("Failed to convertMeasurement: " + error);
            return null;
        }

        boolean multiply = true;

        MeasurementConversionEntity conversionEntity =
                measurementConversionService.findMeasurementConversionByMeasurements(from, to);

        if (conversionEntity == null) {
            conversionEntity = measurementConversionService.findMeasurementConversionByMeasurements(to, from);
            multiply = false;
        }

        if (multiply)
            return RoundingHelper.RoundTo2DecimalPlaces(fromAmount * conversionEntity.getMultiplier());
        return RoundingHelper.RoundTo2DecimalPlaces(fromAmount / conversionEntity.getMultiplier());
    }

    private String checkForNullValues(Double fromAmount, MeasurementEntity from, MeasurementEntity to) {
        StringBuilder builder = new StringBuilder();
        if (fromAmount == null || fromAmount.isNaN())
            builder.append("Double fromAmount is null or not a number");
        else if (fromAmount == 0.0)
            builder.append("Double fromAmount is 0");

        if (from == null)
            builder.append("MeasurementEntity \"from\" could not be found");
        if (to == null)
            builder.append("MeasurementEntity \"to\" could not be found");
        return builder.toString();
    }

}

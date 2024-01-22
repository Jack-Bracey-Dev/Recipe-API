package com.jackbracey.recipeapi.Controllers;

import com.jackbracey.recipeapi.Entities.MeasurementConversion.MeasurementConversionEntity;
import com.jackbracey.recipeapi.Entities.MeasurementEntity;
import com.jackbracey.recipeapi.Helpers.Response;
import com.jackbracey.recipeapi.POJOs.Measurement;
import com.jackbracey.recipeapi.Repositories.MeasurementConversionRepository;
import com.jackbracey.recipeapi.Services.MeasurementConversionService;
import com.jackbracey.recipeapi.Services.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/measurement-conversion")
public class MeasurementConversionController {

    @Autowired
    private MeasurementConversionService measurementConversionService;

    @Autowired
    private MeasurementService measurementService;

    @GetMapping
    @PreAuthorize("hasAuthority('GET_MEASUREMENT')")
    public Response getAll() {
        return Response.Success(measurementConversionService.getAll());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('CREATE_MEASUREMENT')")
    public Response create(@RequestParam String from, @RequestParam String to, @RequestParam Double multiplier) {
        MeasurementEntity fromMeasurement = measurementService.findMeasurementByName(from);
        MeasurementEntity toMeasurement = measurementService.findMeasurementByName(to);

        if (fromMeasurement == null || toMeasurement == null)
            return new Response(null, 403, "Failed to find one of them");

        MeasurementConversionEntity entity = measurementConversionService.save(new MeasurementConversionEntity(fromMeasurement.getId(), toMeasurement.getId(), multiplier));

        return Response.Success(entity);
    }

}

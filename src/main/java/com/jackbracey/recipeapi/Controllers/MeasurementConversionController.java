package com.jackbracey.recipeapi.Controllers;

import com.jackbracey.recipeapi.Helpers.Response;
import com.jackbracey.recipeapi.Services.MeasurementConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/measurement-conversion")
public class MeasurementConversionController {

    @Autowired
    private MeasurementConversionService measurementConversionService;

    @GetMapping
    @PreAuthorize("hasAuthority('GET_MEASUREMENT')")
    public Response getAll() {
        return Response.Success(measurementConversionService.getAll());
    }

}

package com.jackbracey.recipeapi.Controllers;

import com.jackbracey.recipeapi.Helpers.Response;
import com.jackbracey.recipeapi.Services.MeasurementConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("measurement-conversion")
public class MeasurementConversionController {

    @Autowired
    private MeasurementConversionService measurementConversionService;

    @GetMapping
    public Response getAll() {
        return Response.Success(measurementConversionService.getAll());
    }

}

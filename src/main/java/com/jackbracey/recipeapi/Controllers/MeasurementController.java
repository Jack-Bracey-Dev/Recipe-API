package com.jackbracey.recipeapi.Controllers;

import com.jackbracey.recipeapi.Helpers.Response;
import com.jackbracey.recipeapi.Services.MeasurementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("measurement")
@SuppressWarnings("unused")
@Slf4j
public class MeasurementController {

    @Autowired
    private MeasurementService measurementService;

    @GetMapping
    public Response getMeasurements() {
        try {
            return Response.Success(measurementService.findAll());
        } catch (Exception e) {
            log.error("Error on getMeasurements", e);
            return new Response(null, 500, e.getMessage());
        }
    }

}

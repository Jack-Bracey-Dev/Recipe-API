package com.jackbracey.recipeapi.Controllers;

import com.jackbracey.recipeapi.Helpers.Response;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("api/api-keys")
@RolesAllowed("ADMIN")
public class ApiKeyController {

    @PostMapping("create")
    public Response createNewApiKey() {

        return Response.Success(null);
    }

}

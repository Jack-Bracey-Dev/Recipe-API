package com.jackbracey.recipeapi.RequestFilters.RequestCount;

import com.jackbracey.recipeapi.Entities.ApiKeyEntity;
import com.jackbracey.recipeapi.Services.ApiKeyService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
import java.util.UUID;

@SuppressWarnings("NullableProblems")
@Slf4j
@Component
public class RequestCountCheckFilter implements HandlerInterceptor {

    @Autowired
    private ApiKeyService apiKeyService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String apiKey = request.getHeader("X-API-KEY");
        Optional<ApiKeyEntity> optional = apiKeyService.getApiKey(UUID.fromString(apiKey));

        if (optional.isEmpty()) {
            log.info("Could not find API Key for: " + apiKey);
            return false;
        }

        ApiKeyEntity entity = optional.get();

        if (entity.getType().equalsIgnoreCase("ADMIN"))
            return true;

        if (entity.getRequests() >= 1000) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "You've used all your requests, upgrade your package for more.");
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {}

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String apiKey = request.getHeader("X-API-KEY");
        Optional<ApiKeyEntity> optional = apiKeyService.getApiKey(UUID.fromString(apiKey));

        if (optional.isEmpty()) {
            log.info("Could not find API Key for: " + apiKey);
            return;
        }

        ApiKeyEntity entity = optional.get();

        if (entity.getType().equalsIgnoreCase("ADMIN"))
            return;

        entity.setRequests(entity.getRequests() + 1);

        apiKeyService.save(entity);
    }
}

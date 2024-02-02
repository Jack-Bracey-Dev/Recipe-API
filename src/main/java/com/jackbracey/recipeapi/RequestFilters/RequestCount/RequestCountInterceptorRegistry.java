package com.jackbracey.recipeapi.RequestFilters.RequestCount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SuppressWarnings("ALL")
@Component
public class RequestCountInterceptorRegistry implements WebMvcConfigurer {

    @Autowired
    RequestCountCheckFilter requestCountCheckFilter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestCountCheckFilter);
    }
}

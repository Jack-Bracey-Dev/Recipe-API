package com.jackbracey.recipeapi.Auth;

import com.jackbracey.recipeapi.Services.ApiKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Order(1)
public class AuthConfig {

    private static final String API_KEY_AUTH_HEADER_NAME = "API_KEY";

    @Autowired
    private ApiKeyService apiKeyService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        ApiKeyAuthFilter filter = new ApiKeyAuthFilter(API_KEY_AUTH_HEADER_NAME);
        filter.setAuthenticationManager(new ApiKeyAuthManager(apiKeyService));

        http.csrf(AbstractHttpConfigurer::disable)
                .addFilter(filter)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/api-keys/**").hasRole("ADMIN")
                        .anyRequest()
                        .authenticated());
        return http.build();
    }

}

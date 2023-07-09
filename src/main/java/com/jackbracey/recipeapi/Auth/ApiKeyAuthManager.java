package com.jackbracey.recipeapi.Auth;

import com.jackbracey.recipeapi.Services.ApiKeyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.UUID;

@Slf4j
public class ApiKeyAuthManager implements AuthenticationManager {

    private final ApiKeyService apiKeyService;

    public ApiKeyAuthManager(ApiKeyService apiKeyService) {
        this.apiKeyService = apiKeyService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String principal = (String) authentication.getPrincipal();
        if (apiKeyService.exists(UUID.fromString(principal))) {
            authentication.setAuthenticated(true);
//            authentication.getAuthorities().add(new SimpleGrantedAuthority(""));

            return authentication;
        } else {
            throw new BadCredentialsException("This api key does not exist");
        }
    }

}

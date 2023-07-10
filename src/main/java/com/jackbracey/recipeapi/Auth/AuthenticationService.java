package com.jackbracey.recipeapi.Auth;

import com.jackbracey.recipeapi.Entities.ApiKeyEntity;
import com.jackbracey.recipeapi.Services.ApiKeyService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.util.Strings;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public class AuthenticationService {

    private static final String AUTH_TOKEN_HEADER_NAME = "X-API-KEY";

    private static final String OPEN_ENDPOINT_KEY = "TEMP-API-KEY";

    public static Authentication getAuthentication(HttpServletRequest request, ApiKeyService apiKeyService) {
        String apiKey = request.getHeader(AUTH_TOKEN_HEADER_NAME);

        if (Strings.isEmpty(apiKey)) {
            if (!SecurityConfig.OpenEndpoints.contains(request.getServletPath()))
                throw new BadCredentialsException("Invalid API Key");

            /* No API Key but it's an open endpoint */
            return new ApiKeyAuthentication(OPEN_ENDPOINT_KEY, AuthorityUtils.NO_AUTHORITIES);
        } else {
            Optional<ApiKeyEntity> optionalApiKey = apiKeyService.getApiKey(UUID.fromString(apiKey));

            if (optionalApiKey.isEmpty() && !SecurityConfig.OpenEndpoints.contains(request.getServletPath()))
                throw new BadCredentialsException("Invalid API Key");

            if (optionalApiKey.isEmpty() && SecurityConfig.OpenEndpoints.contains(request.getServletPath()))
                return new ApiKeyAuthentication(OPEN_ENDPOINT_KEY, AuthorityUtils.NO_AUTHORITIES);

            if (optionalApiKey.isPresent()) {
                ApiKeyEntity key = optionalApiKey.get();
                Collection<GrantedAuthority> authorities = key.getAllAuthorities();
                if (authorities.size() > 0)
                    return new ApiKeyAuthentication(apiKey, authorities);
                return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);
            }

            throw new BadCredentialsException("Invalid API Key");
        }
    }

}

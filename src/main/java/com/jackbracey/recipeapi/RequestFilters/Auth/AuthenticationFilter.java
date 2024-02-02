package com.jackbracey.recipeapi.RequestFilters.Auth;

import com.jackbracey.recipeapi.Services.ApiKeyService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

import static com.jackbracey.recipeapi.RequestFilters.Auth.AuthenticationService.AUTH_TOKEN_HEADER_NAME;

@Slf4j
public class AuthenticationFilter extends GenericFilterBean {

    private final ApiKeyService apiKeyService;

    public AuthenticationFilter(ApiKeyService apiKeyService) {
        this.apiKeyService = apiKeyService;
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
        try {
            Authentication authentication = AuthenticationService.getAuthentication((HttpServletRequest) request,
                    apiKeyService);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (BadCredentialsException ex) {
            log.info("Failed to validate API Key: " + ((HttpServletRequest) request).getHeader(AUTH_TOKEN_HEADER_NAME));
        }

        filterChain.doFilter(request, response);
    }
}

package com.jackbracey.recipeapi.Auth;

import org.springframework.security.core.GrantedAuthority;

public class ApiKeyAuthority implements GrantedAuthority {

    private String authority;

    public ApiKeyAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}

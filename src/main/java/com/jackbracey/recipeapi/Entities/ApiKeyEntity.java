package com.jackbracey.recipeapi.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity(name = "api_keys")
public class ApiKeyEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID apikey;

    private String role;

    public ApiKeyEntity(UUID apikey, String role) {
        this.apikey = apikey;
        this.role = role;
    }

    public ApiKeyEntity(UUID apikey) {
        this.apikey = apikey;
    }

    public ApiKeyEntity() {
    }

    public UUID getApikey() {
        return apikey;
    }

    public void setApikey(UUID apikey) {
        this.apikey = apikey;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

package com.jackbracey.recipeapi.POJOs.BBC;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RecipeOverviewMetaBBC {

    public String entity;

    public String source;

    public String clientId;

    public RecipeOverviewMetaBBC(String entity, String source, String clientId) {
        this.entity = entity;
        this.source = source;
        this.clientId = clientId;
    }

    public RecipeOverviewMetaBBC() {
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}

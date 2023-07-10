package com.jackbracey.recipeapi.Entities.Permissions;

import java.io.Serializable;

public class ApiKeyPermissionsPk implements Serializable {

    private Integer apiKeyId;

    private Integer permissionId;

    public ApiKeyPermissionsPk() {
    }

    public ApiKeyPermissionsPk(Integer apiKeyId, Integer permissionId) {
        this.apiKeyId = apiKeyId;
        this.permissionId = permissionId;
    }

    public Integer getApiKeyId() {
        return apiKeyId;
    }

    public void setApiKeyId(Integer apiKeyId) {
        this.apiKeyId = apiKeyId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}

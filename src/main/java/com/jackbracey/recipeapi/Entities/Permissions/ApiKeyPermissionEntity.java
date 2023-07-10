package com.jackbracey.recipeapi.Entities.Permissions;

import jakarta.persistence.*;

@Entity(name = "api_key_permissions")
@IdClass(ApiKeyPermissionsPk.class)
public class ApiKeyPermissionEntity {

    @Id
    @Column(name = "apikey_id")
    private Integer apiKeyId;

    @Id
    @Column(name = "permission_id")
    private Integer permissionId;

    @OneToOne(optional = false)
    @JoinColumn(name = "permission_Id", referencedColumnName = "id", insertable = false, updatable = false)
    private PermissionEntity permission;

    public ApiKeyPermissionEntity() {
    }

    public ApiKeyPermissionEntity(Integer apiKeyId, Integer permissionId) {
        this.apiKeyId = apiKeyId;
        this.permissionId = permissionId;
    }

    public ApiKeyPermissionEntity(Integer apiKeyId, Integer permissionId, PermissionEntity permission) {
        this.apiKeyId = apiKeyId;
        this.permissionId = permissionId;
        this.permission = permission;
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

    public PermissionEntity getPermission() {
        return permission;
    }

    public void setPermission(PermissionEntity permission) {
        this.permission = permission;
    }
}

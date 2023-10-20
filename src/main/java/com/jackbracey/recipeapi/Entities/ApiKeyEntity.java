package com.jackbracey.recipeapi.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jackbracey.recipeapi.Entities.Permissions.ApiKeyPermissionEntity;
import com.jackbracey.recipeapi.Entities.Permissions.PermissionEntity;
import com.jackbracey.recipeapi.POJOs.GenericKeyType;
import com.jackbracey.recipeapi.POJOs.Permission;
import com.jackbracey.recipeapi.Services.ApiKeyPermissionService;
import com.jackbracey.recipeapi.Services.ApiKeyService;
import com.jackbracey.recipeapi.Services.PermissionService;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity(name = "api_keys")
@JsonIgnoreProperties(value = { "permissions" })
public class ApiKeyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "api_key")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID key;

    @Column(name = "type")
    private String type;

    @Column(name = "requests")
    private Long requests;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "apikey_id", referencedColumnName = "id")
    private List<ApiKeyPermissionEntity> permissions = new ArrayList<>();

    public ApiKeyEntity() {
    }

    public static ApiKeyEntity createUnsavedKey(GenericKeyType type, PermissionService permissionService) {
        ApiKeyEntity entity = new ApiKeyEntity();
        List<ApiKeyPermissionEntity> apiKeyPermissionEntities = new ArrayList<>();

        for (Permission permission : type.getDefaultPermissions()) {
            PermissionEntity permissionEntity = permissionService.findPermission(permission.getName());
            apiKeyPermissionEntities.add(new ApiKeyPermissionEntity(null, permissionEntity.getId()));
        }

        entity.setPermissions(apiKeyPermissionEntities);
        entity.setType(type.name());
        entity.setRequests(0L);
        return entity;
    }

    /* This must be used with a saved ApiKeyEntity and will fill out the id in the id in the permissions */
    public static void fillOutPermissions(ApiKeyEntity entity, ApiKeyPermissionService service) throws Exception {
        if (entity.getId() == null)
            throw new Exception("ApiKeyEntity must be saved and have an id in order to run fillOutPermissions function");

        List<ApiKeyPermissionEntity> unfilledPermissions = entity.getPermissions();
        List<ApiKeyPermissionEntity> filledPermissions = new ArrayList<>();

        for (ApiKeyPermissionEntity apiKeyPermissionEntity : unfilledPermissions) {
            apiKeyPermissionEntity.setApiKeyId(entity.getId());
            ApiKeyPermissionEntity apiKeyPermissionEntitySaved = service.createApiKeyPermissionEntry(
                    apiKeyPermissionEntity.getApiKeyId(), apiKeyPermissionEntity.getPermissionId());
            filledPermissions.add(apiKeyPermissionEntitySaved);
        }

        entity.setPermissions(filledPermissions);
    }

    @PrePersist
    public void prePersist() {
        if (this.key == null)
            this.key = UUID.randomUUID();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UUID getKey() {
        return key;
    }

    public void setKey(UUID key) {
        this.key = key;
    }

    public List<ApiKeyPermissionEntity> getPermissions() {
        return permissions;
    }

    public Collection<GrantedAuthority> getAllAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<>();
        if (this.permissions == null || this.permissions.size() == 0)
            return auths;

        for (ApiKeyPermissionEntity apiKeyPermissionEntity : this.permissions)
            if (apiKeyPermissionEntity.getPermission() != null)
                auths.add(new SimpleGrantedAuthority(apiKeyPermissionEntity.getPermission().getName()));
        return auths;
    }

    public void setPermissions(List<ApiKeyPermissionEntity> permissions) {
        this.permissions = permissions;
    }

    public void setPermissions(ApiKeyPermissionService apiKeyPermissionService,
                               PermissionService permissionService,
                               List<Permission> permissions) {
        List<ApiKeyPermissionEntity> permissionEntities = new ArrayList<>();
        for (Permission permission : permissions) {
            PermissionEntity permissionEntity = permissionService.findPermission(permission);
            ApiKeyPermissionEntity apiKeyPermissionEntity = apiKeyPermissionService
                    .createApiKeyPermissionEntry(this.id, permissionEntity.getId());
            permissionEntities.add(apiKeyPermissionEntity);
        }
        setPermissions(permissionEntities);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getRequests() {
        return requests;
    }

    public void setRequests(Long requests) {
        this.requests = requests;
    }
}

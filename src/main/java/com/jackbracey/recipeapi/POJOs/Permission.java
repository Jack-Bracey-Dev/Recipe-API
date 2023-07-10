package com.jackbracey.recipeapi.POJOs;

import com.jackbracey.recipeapi.Entities.Permissions.PermissionEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Permission implements Serializable {

    private String name;

    public Permission(String name) {
        this.name = name;
    }

    public Permission() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<PermissionEntity> convertListToEntities(List<Permission> permissions) {
        List<PermissionEntity> entities = new ArrayList<>();
        for (Permission permission : permissions)
            entities.add(convertToEntity(permission));
        return entities;
    }

    public static PermissionEntity convertToEntity(Permission permission) {
        return new PermissionEntity(permission.getName());
    }

}

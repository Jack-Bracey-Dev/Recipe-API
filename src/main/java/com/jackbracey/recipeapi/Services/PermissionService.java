package com.jackbracey.recipeapi.Services;

import com.jackbracey.recipeapi.Entities.Permissions.PermissionEntity;
import com.jackbracey.recipeapi.Repositories.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    public List<PermissionEntity> getAllPermissions() {
        return permissionRepository.findAll();
    }

    public PermissionEntity savePermission(PermissionEntity permission) {
        return permissionRepository.save(permission);
    }

    public List<PermissionEntity> savePermissions(List<PermissionEntity> permissions) {
        return permissionRepository.saveAll(permissions);
    }

    public PermissionEntity findPermission(String name) {
        return permissionRepository.findByName(name);
    }

}

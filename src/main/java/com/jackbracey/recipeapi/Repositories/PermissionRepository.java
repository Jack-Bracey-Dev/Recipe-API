package com.jackbracey.recipeapi.Repositories;

import com.jackbracey.recipeapi.Entities.Permissions.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionEntity, Integer> {
    PermissionEntity findByName(String name);
}

package com.jackbracey.recipeapi.POJOs;

import java.util.ArrayList;
import java.util.List;

public enum GenericKeyType {

    TRIAL_USER(List.of(
            new Permission(Permissions.GET_RECIPE.name()),
            new Permission(Permissions.GET_MEASUREMENT.name())
    ), 500L, null),

    USER(List.of(
            new Permission(Permissions.GET_RECIPE.name()),
            new Permission(Permissions.GET_MEASUREMENT.name())
    ),null, null),

    ADMIN(List.of(
            new Permission(Permissions.CREATE_RECIPE.name()),
            new Permission(Permissions.EDIT_RECIPE.name()),
            new Permission(Permissions.DELETE_RECIPE.name()),
            new Permission(Permissions.GET_PERMISSION.name()),
            new Permission(Permissions.CREATE_PERMISSION.name()),
            new Permission(Permissions.REMOVE_PERMISSION.name()),
            new Permission(Permissions.ASSIGN_PERMISSION.name()),
            new Permission(Permissions.GET_API_KEY.name()),
            new Permission(Permissions.CREATE_API_KEY.name()),
            new Permission(Permissions.REMOVE_API_KEY.name()),
            new Permission(Permissions.DEV_TEST_ACCOUNT.name())
    ), null, USER);

    private final List<Permission> defaultPermissions;

    private final Long allowedRequests;

    private final GenericKeyType inheritFrom;

    GenericKeyType(List<Permission> defaultPermissions, Long allowedRequests, GenericKeyType inheritFrom) {
        this.defaultPermissions = defaultPermissions;
        this.allowedRequests = allowedRequests;
        this.inheritFrom = inheritFrom;
    }

    public List<Permission> getDefaultPermissions() {
        List<Permission> actualPermissions;

        if (inheritFrom != null)
            actualPermissions = new ArrayList<>(inheritFrom.getDefaultPermissions());
        else
            actualPermissions = new ArrayList<>();

        actualPermissions.addAll(defaultPermissions);
        return actualPermissions;
    }

    public Long getAllowedRequests() {
        return allowedRequests;
    }

    public GenericKeyType getInheritFrom() {
        return inheritFrom;
    }
}

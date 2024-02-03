package com.jackbracey.recipeapi.POJOs;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public enum GenericKeyType {

    FREE_USER(List.of(
            new Permission("GET_RECIPE"),
            new Permission("GET_MEASUREMENT")
    ), 300L, null),

    USER_T1(List.of(
            new Permission("GET_RECIPE"),
            new Permission("GET_MEASUREMENT")
    ),50000L, null),

    USER_T2(List.of(
            new Permission("GET_RECIPE"),
            new Permission("GET_MEASUREMENT")
    ),400000L, null),

    USER_T3(List.of(
            new Permission("GET_RECIPE"),
            new Permission("GET_MEASUREMENT")
    ),500000L, null),

    ADMIN(List.of(
            new Permission("CREATE_RECIPE"),
            new Permission("EDIT_RECIPE"),
            new Permission("DELETE_RECIPE"),
            new Permission("GET_PERMISSION"),
            new Permission("CREATE_PERMISSION"),
            new Permission("REMOVE_PERMISSION"),
            new Permission("ASSIGN_PERMISSION"),
            new Permission("GET_API_KEY"),
            new Permission("CREATE_API_KEY"),
            new Permission("REMOVE_API_KEY")
    ), null, USER_T3);

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

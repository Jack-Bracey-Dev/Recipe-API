package com.jackbracey.recipeapi.POJOs.Enums;

import java.util.List;

public enum FeatureFlagDataType {

    STRING,
    INTEGER,
    LONG,
    BOOLEAN;

    public static FeatureFlagDataType get(String name) throws Exception {
        List<FeatureFlagDataType> types = List.of(FeatureFlagDataType.values());
        List<FeatureFlagDataType> found = types.stream().filter(type -> type.name().equalsIgnoreCase(name)).toList();
        if (found.size() < 1)
            throw new Exception(String.format("FeatureFlagDataType doesn't contain %s", name));
        return found.get(0);
    }

    public static FeatureFlagDataType get(int ordinal) {
        return FeatureFlagDataType.values()[ordinal];
    }
}

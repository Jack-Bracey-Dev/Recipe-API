package com.jackbracey.recipeapi.Entities.Permissions;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity(name = "permissions")
public class PermissionEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    public PermissionEntity() {
    }

    public PermissionEntity(String name) {
        this.name = name;
    }

    public PermissionEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

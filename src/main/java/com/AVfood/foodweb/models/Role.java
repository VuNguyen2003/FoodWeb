package com.AVfood.foodweb.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Role")
public class Role implements Serializable {

    @Id
    @Column(name = "RoleId", nullable = false, length = 100)
    private String roleId;

    // Constructors
    public Role() {}

    public Role(String roleId) {
        this.roleId = roleId;
    }

    // Getters and Setters
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}

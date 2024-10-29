package com.AVfood.foodweb.models;

import jakarta.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @Column(name = "role_id", length = 100)
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

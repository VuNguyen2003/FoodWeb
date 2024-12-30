package com.AVfood.foodweb.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Role")
public class Role {

    @Id
    @Column(name = "Role_Id", length = 100)
    private String roleId;

    // Constructors, Getters and Setters
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

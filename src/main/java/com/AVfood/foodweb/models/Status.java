package com.AVfood.foodweb.models;

import jakarta.persistence.*;

@Entity
@Table(name = "status")
public class Status {

    @Id
    @Column(name = "status_id", length = 100)
    private String statusId;

    @Column(name = "status_name", length = 100)
    private String statusName;

    // Constructors
    public Status() {}

    public Status(String statusId, String statusName) {
        this.statusId = statusId;
        this.statusName = statusName;
    }

    // Getters and Setters
    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}

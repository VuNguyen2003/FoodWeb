package com.AVfood.foodweb.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Status")
public class Status {

    @Id
    @Column(name = "Status_Id", length = 100)
    private String statusId;

    @Column(name = "Status_Name", length = 100)
    private String statusName;

    // Constructors, Getters and Setters
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

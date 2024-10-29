package com.AVfood.foodweb.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Status")
public class Status implements Serializable {

    @Id
    @Column(name = "StatusId", length = 100)
    private String statusId;

    @Column(name = "StatusName", length = 100)
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

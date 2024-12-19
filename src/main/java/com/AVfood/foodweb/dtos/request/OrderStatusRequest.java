package com.AVfood.foodweb.dtos.request;

public class OrderStatusRequest {

    private String statusId;
    private String statusName;

    // Constructors
    public OrderStatusRequest() {}

    public OrderStatusRequest(String statusName) {
        this.statusId = statusId;
        this.statusName = statusName;
    }

    // Getter and Setter for statusId
    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    // Getters and Setters
    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}

package com.AVfood.foodweb.models;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @Column(name = "Category_Id", length = 100)
    private String categoryId;

    @Column(name = "Status_Id", length = 100)
    private String statusId;

    @Column(name = "Order_Name", length = 100)
    private String orderName;

    // Constructors
    public Category() {}

    public Category(String categoryId, String statusId, String orderName) {
        this.categoryId = categoryId;
        this.statusId = statusId;
        this.orderName = orderName;
    }

    // Getters and Setters
    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
}

package com.AVfood.foodweb.models;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @Column(name = "category_id", length = 100)
    private String categoryId;

    @Column(name = "status_id", length = 100)
    private String statusId;

    @Column(name = "order_name", length = 100)
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

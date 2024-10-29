package com.AVfood.foodweb.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Category")
public class Category implements Serializable {

    @Id
    @Column(name = "CategoryId", length = 100)
    private String categoryId;

    @Column(name = "StatusId", length = 100)
    private String statusId;

    @Column(name = "OrderName", length = 100)
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

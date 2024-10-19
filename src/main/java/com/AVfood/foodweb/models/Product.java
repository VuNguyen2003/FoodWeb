package com.AVfood.foodweb.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Product")
public class Product implements Serializable {

    @Id
    @Column(name = "ProductId", nullable = false, length = 100)
    private String productId;

    @Column(name = "CategoryId", length = 100)
    private String categoryId;

    @Column(name = "ProductName", length = 100)
    private String productName;

    @Column(name = "ProductDescripsion", length = 1000)
    private String productDescripsion;

    @Column(name = "Stock")
    private int stock;

    @Column(name = "ProductImageUrl", length = 1000)
    private String productImageUrl;

    @Column(name = "View")
    private int view;

    @Column(name = "like")
    private int like;

    // Constructors
    public Product() {}

    public Product(String productId, String categoryId, String productName, String productDescripsion, int stock, String productImageUrl, int view, int like) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.productName = productName;
        this.productDescripsion = productDescripsion;
        this.stock = stock;
        this.productImageUrl = productImageUrl;
        this.view = view;
        this.like = like;
    }

    // Getters and Setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescripsion() {
        return productDescripsion;
    }

    public void setProductDescripsion(String productDescripsion) {
        this.productDescripsion = productDescripsion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}

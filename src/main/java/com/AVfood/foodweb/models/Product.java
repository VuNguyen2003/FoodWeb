package com.AVfood.foodweb.models;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "product_id", length = 100)
    private String productId;

    @Column(name = "category_id", length = 100)
    private String categoryId;

    @Column(name = "product_name", length = 100)
    private String productName;

    @Column(name = "product_description", length = 1000)
    private String productDescription;

    @Column(name = "stock")
    private int stock;

    @Column(name = "product_image_url", length = 1000)
    private String productImageUrl;

    @Column(name = "view")
    private int view;

    @Column(name = "likes")
    private int likes;

    // Constructors
    public Product() {}

    public Product(String productId, String categoryId, String productName, String productDescription, int stock, String productImageUrl, int view, int likes) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.stock = stock;
        this.productImageUrl = productImageUrl;
        this.view = view;
        this.likes = likes;
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

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}

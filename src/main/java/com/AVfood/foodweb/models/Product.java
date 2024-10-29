package com.AVfood.foodweb.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Product")
public class Product implements Serializable {

    @Id
    @Column(name = "ProductId", length = 100)
    private long productId;

    @Column(name = "CategoryId", length = 100)
    private String categoryId;

    @Column(name = "ProductName", length = 100)
    private String productName;

    @Column(name = "ProductDescription", length = 1000)
    private String productDescription;

    @Column(name = "Stock")
    private int stock;

    @Column(name = "ProductImageUrl", length = 1000)
    private String productImageUrl;

    @Column(name = "View")
    private int view;

    @Column(name = "Likes")
    private int likes;

    // Constructors
    public Product() {}

    public Product(long productId, String categoryId, String productName, String productDescription, int stock, String productImageUrl, int view, int likes) {
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
    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
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

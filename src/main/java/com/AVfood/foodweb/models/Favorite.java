package com.AVfood.foodweb.models;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "favorite")
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favorite_id")
    private String favoriteId;

    @Column(name = "account_id", nullable = false)
    private String accountId;

    @Column(name = "product_id", nullable = false)
    private String productId;

    @Column(name = "liked_date", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp likedDate;

    // Constructors
    public Favorite() {}

    public Favorite(String favoriteId, String accountId, String productId, Timestamp likedDate) {
        this.favoriteId = favoriteId;
        this.accountId = accountId;
        this.productId = productId;
        this.likedDate = likedDate;
    }

    // Getters and Setters
    public String getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(String favoriteId) {
        this.favoriteId = favoriteId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Timestamp getLikedDate() {
        return likedDate;
    }

    public void setLikedDate(Timestamp likedDate) {
        this.likedDate = likedDate;
    }
}
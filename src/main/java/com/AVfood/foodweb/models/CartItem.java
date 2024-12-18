package com.AVfood.foodweb.models;

import jakarta.persistence.*;

@Entity
@Table(name = "cart_item")
public class CartItem {

    @Id
    @Column(name = "cart_item_id", length = 100)
    private String cartItemId;

    @Column(name = "cart_id", length = 100)
    private String cartId;

    @Column(name = "product_id", length = 100)
    private String productId;

    @Column(name = "quantity_item")
    private int quantityItem;

    @Column(name = "total_item", precision = 10, scale = 2)
    private java.math.BigDecimal totalItem;

    // Constructors
    public CartItem() {}

    public CartItem(String cartItemId, String cartId, String productId, int quantityItem, java.math.BigDecimal totalItem) {
        this.cartItemId = cartItemId;
        this.cartId = cartId;
        this.productId = productId;
        this.quantityItem = quantityItem;
        this.totalItem = totalItem;
    }

    // Getters and Setters
    public String getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(String cartItemId) {
        this.cartItemId = cartItemId;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantityItem() {
        return quantityItem;
    }

    public void setQuantityItem(int quantityItem) {
        this.quantityItem = quantityItem;
    }

    public java.math.BigDecimal getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(java.math.BigDecimal totalItem) {
        this.totalItem = totalItem;
    }
}

package com.AVfood.foodweb.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "CartItem")
public class CartItem implements Serializable {

    @Id
    @Column(name = "CartItemId", nullable = false, length = 100)
    private String cartItemId;

    @Column(name = "CartId", nullable = false, length = 100)
    private String cartId;

    @Column(name = "ProductId", nullable = false, length = 100)
    private Long productId;

    @Column(name = "QuantityItem", nullable = false)
    private int quantityItem;

    @Column(name = "TotalItem", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalItem;

    // Constructors
    public CartItem() {}

    public CartItem(String cartItemId, String cartId, long productId, int quantityItem, BigDecimal totalItem) {
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

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getQuantityItem() {
        return quantityItem;
    }

    public void setQuantityItem(int quantityItem) {
        this.quantityItem = quantityItem;
    }

    public BigDecimal getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(BigDecimal totalItem) {
        this.totalItem = totalItem;
    }
}

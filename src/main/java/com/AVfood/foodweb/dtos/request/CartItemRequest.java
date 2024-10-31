package com.AVfood.foodweb.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public class CartItemRequest {

    @NotBlank(message = "CartItemId is required")
    private String cartItemId;

    @NotBlank(message = "CartId is required")
    private String cartId;

    @NotNull(message = "ProductId is required")
    private Long productId;

    @Positive(message = "QuantityItem must be greater than zero")
    private int quantityItem;

    @NotNull(message = "TotalItem is required")
    private BigDecimal totalItem;

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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
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

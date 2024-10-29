package com.AVfood.foodweb.models;
import java.util.List;

public class CartResponse {
    private String message;
    private List<CartItem> items;

    public CartResponse(String message, List<CartItem> items) {
        this.message = message;
        this.items = items;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }
}

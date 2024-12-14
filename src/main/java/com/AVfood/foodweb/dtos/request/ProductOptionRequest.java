package com.AVfood.foodweb.dtos.request;

public class ProductOptionRequest {
    private String productId;
    private String optionCategoryId;

    // Constructors
    public ProductOptionRequest() {}

    public ProductOptionRequest(String productId, String optionCategoryId) {
        this.productId = productId;
        this.optionCategoryId = optionCategoryId;
    }

    // Getters and Setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getOptionCategoryId() {
        return optionCategoryId;
    }

    public void setOptionCategoryId(String optionCategoryId) {
        this.optionCategoryId = optionCategoryId;
    }
}

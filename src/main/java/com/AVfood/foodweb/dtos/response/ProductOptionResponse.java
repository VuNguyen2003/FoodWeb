package com.AVfood.foodweb.dtos.response;

public class ProductOptionResponse {
    private String productOptionId;
    private String productId;
    private String optionCategoryId;

    // Constructors
    public ProductOptionResponse() {}

    public ProductOptionResponse(String productOptionId, String productId, String optionCategoryId) {
        this.productOptionId = productOptionId;
        this.productId = productId;
        this.optionCategoryId = optionCategoryId;
    }

    // Getters and Setters
    public String getProductOptionId() {
        return productOptionId;
    }

    public void setProductOptionId(String productOptionId) {
        this.productOptionId = productOptionId;
    }

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

package com.AVfood.foodweb.models;

import jakarta.persistence.*;

@Entity
@Table(name = "product_option")
public class ProductOption {

    @Id
    @Column(name = "product_option_id")
    private String productOptionId;

    @Column(name = "product_id", nullable = false)
    private String productId;

    @Column(name = "option_category_id", nullable = false)
    private String optionCategoryId;

    // Constructors
    public ProductOption() {}

    public ProductOption(String productOptionId, String productId, String optionCategoryId) {
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
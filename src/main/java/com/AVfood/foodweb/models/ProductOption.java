package com.AVfood.foodweb.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "Product_Option")
public class ProductOption {

    @Id
    @Column(name = "Product_Option_Id")
    private String productOptionId;

    @ManyToOne
    @JoinColumn(name = "Product_Id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "Option_Category_Id", nullable = false)
    private OptionCategory optionCategory;

    // Constructors
    public ProductOption() {}

    public ProductOption(String productOptionId, Product product, OptionCategory optionCategory) {
        this.productOptionId = productOptionId;
        this.product = product;
        this.optionCategory = optionCategory;
    }

    // Getters and Setters
    public String getProductOptionId() {
        return productOptionId;
    }

    public void setProductOptionId(String productOptionId) {
        this.productOptionId = productOptionId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public OptionCategory getOptionCategory() {
        return optionCategory;
    }

    public void setOptionCategory(OptionCategory optionCategory) {
        this.optionCategory = optionCategory;
    }
}


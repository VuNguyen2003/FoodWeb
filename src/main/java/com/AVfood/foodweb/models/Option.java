package com.AVfood.foodweb.models;

import jakarta.persistence.*;

@Entity
@Table(name = "option")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id")
    private String optionId;

    @Column(name = "option_category_id", nullable = false)
    private String optionCategoryId;

    @Column(name = "option_name", nullable = false, length = 255)
    private String optionName;

    @Column(name = "additional_price", nullable = false)
    private double additionalPrice;

    // Constructors
    public Option() {}

    public Option(String optionId, String optionCategoryId, String optionName, double additionalPrice) {
        this.optionId = optionId;
        this.optionCategoryId = optionCategoryId;
        this.optionName = optionName;
        this.additionalPrice = additionalPrice;
    }

    // Getters and Setters
    public String getOptionId() {
        return optionId;
    }

    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }

    public String getOptionCategoryId() {
        return optionCategoryId;
    }

    public void setOptionCategoryId(String optionCategoryId) {
        this.optionCategoryId = optionCategoryId;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public double getAdditionalPrice() {
        return additionalPrice;
    }

    public void setAdditionalPrice(double additionalPrice) {
        this.additionalPrice = additionalPrice;
    }
}

package com.AVfood.foodweb.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Option")
public class Option {

    @Id  // Chỉnh sửa dòng này: sử dụng @Id từ jakarta.persistence
    @Column(name = "Option_Id")
    private String optionId;

    @ManyToOne
    @JoinColumn(name = "Option_Category_Id", nullable = false)
    private OptionCategory optionCategory;

    @Column(name = "Option_Name", nullable = false)
    private String optionName;

    @Column(name = "Additional_Price", nullable = false)
    private double additionalPrice;

    // Constructors
    public Option() {}

    public Option(String optionId, OptionCategory optionCategory, String optionName, double additionalPrice) {
        this.optionId = optionId;
        this.optionCategory = optionCategory;
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

    public OptionCategory getOptionCategory() {
        return optionCategory;
    }

    public void setOptionCategory(OptionCategory optionCategory) {
        this.optionCategory = optionCategory;
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

package com.AVfood.foodweb.dtos.response;

public class OptionResponse {
    private String optionId;
    private String optionCategoryId;
    private String optionName;
    private double additionalPrice;

    // Constructors
    public OptionResponse() {}

    public OptionResponse(String optionId, String optionCategoryId, String optionName, double additionalPrice) {
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

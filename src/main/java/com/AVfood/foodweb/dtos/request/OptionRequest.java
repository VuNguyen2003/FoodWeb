package com.AVfood.foodweb.dtos.request;

public class OptionRequest {
    private String optionCategoryId;
    private String optionName;
    private double additionalPrice;

    // Constructors
    public OptionRequest() {}

    public OptionRequest(String optionCategoryId, String optionName, double additionalPrice) {
        this.optionCategoryId = optionCategoryId;
        this.optionName = optionName;
        this.additionalPrice = additionalPrice;
    }

    // Getters and Setters
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

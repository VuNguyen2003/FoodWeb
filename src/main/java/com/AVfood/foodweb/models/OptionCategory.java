package com.AVfood.foodweb.models;

import jakarta.persistence.*;

@Entity
@Table(name = "option_category")
public class OptionCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_category_id")
    private String optionCategoryId;

    @Column(name = "category_name", nullable = false, length = 255)
    private String categoryName;

    // Constructors
    public OptionCategory() {}

    public OptionCategory(String optionCategoryId, String categoryName) {
        this.optionCategoryId = optionCategoryId;
        this.categoryName = categoryName;
    }

    // Getters and Setters
    public String getOptionCategoryId() {
        return optionCategoryId;
    }

    public void setOptionCategoryId(String optionCategoryId) {
        this.optionCategoryId = optionCategoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}

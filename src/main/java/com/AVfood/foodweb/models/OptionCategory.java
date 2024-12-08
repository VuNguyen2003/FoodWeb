package com.AVfood.foodweb.models;

import com.AVfood.foodweb.models.Option;
import com.AVfood.foodweb.models.ProductOption;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Option_Category")
public class OptionCategory {

    @Id
    @Column(name = "Option_Category_Id")
    private String optionCategoryId;

    @Column(name = "Category_Name", nullable = false)
    private String categoryName;

    @OneToMany(mappedBy = "optionCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Option> options;

    @OneToMany(mappedBy = "optionCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductOption> productOptions;

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

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public List<ProductOption> getProductOptions() {
        return productOptions;
    }

    public void setProductOptions(List<ProductOption> productOptions) {
        this.productOptions = productOptions;
    }
}

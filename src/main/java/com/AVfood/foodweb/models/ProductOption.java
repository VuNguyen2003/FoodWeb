package com.AVfood.foodweb.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Product_Option")
public class ProductOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Thêm @GeneratedValue nếu muốn giá trị tự động cho khóa chính
    @Column(name = "Product_Option_Id")
    private Long productOptionId; // Thay đổi kiểu dữ liệu thành Long nếu muốn sử dụng số tự động

    @ManyToOne
    @JoinColumn(name = "Product_Id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "Option_Category_Id", nullable = false)
    private OptionCategory optionCategory;

    // Constructors
    public ProductOption() {}

    public ProductOption(Product product, OptionCategory optionCategory) {
        this.product = product;
        this.optionCategory = optionCategory;
    }

    // Getters and Setters
    public Long getProductOptionId() {
        return productOptionId;
    }

    public void setProductOptionId(Long productOptionId) {
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

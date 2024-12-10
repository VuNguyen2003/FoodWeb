package com.AVfood.foodweb.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Order_Details_Option")
public class OrderDetailsOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Thêm @GeneratedValue để Hibernate tự động tạo giá trị cho khóa chính
    @Column(name = "Order_Details_Option_Id")
    private Long orderDetailsOptionId; // Thay đổi kiểu dữ liệu thành Long nếu khóa chính là số tự động

    @ManyToOne
    @JoinColumn(name = "Order_Detail_Id", nullable = false)
    private OrderDetails orderDetails;

    @ManyToOne
    @JoinColumn(name = "Option_Id", nullable = false)
    private Option option;

    // Constructors
    public OrderDetailsOption() {}

    public OrderDetailsOption(OrderDetails orderDetails, Option option) {
        this.orderDetails = orderDetails;
        this.option = option;
    }

    // Getters and Setters
    public Long getOrderDetailsOptionId() {
        return orderDetailsOptionId;
    }

    public void setOrderDetailsOptionId(Long orderDetailsOptionId) {
        this.orderDetailsOptionId = orderDetailsOptionId;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }
}

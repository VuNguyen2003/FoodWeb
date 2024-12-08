package com.AVfood.foodweb.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "Order_Details_Option")
public class OrderDetailsOption {
    @Id
    @Column(name = "Order_Details_Option_Id")
    private String orderDetailsOptionId;

    @ManyToOne
    @JoinColumn(name = "Order_Detail_Id", nullable = false)
    private OrderDetails orderDetails;

    @ManyToOne
    @JoinColumn(name = "Option_Id", nullable = false)
    private Option option;

    // Constructors, Getters, Setters
}

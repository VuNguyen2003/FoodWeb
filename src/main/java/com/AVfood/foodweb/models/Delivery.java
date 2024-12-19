package com.AVfood.foodweb.models;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private String deliveryId;

    @Column(name = "order_id", nullable = false)
    private String orderId;  // Mã đơn hàng

    @Column(name = "delivery_person_name", length = 255)
    private String deliveryPersonName;  // Tên người giao hàng

    @Column(name = "delivery_person_phone", length = 15)
    private String deliveryPersonPhone;  // Số điện thoại người giao hàng

    @Column(name = "delivery_status", length = 50, nullable = false, columnDefinition = "varchar(50) default 'Pending'")
    private String deliveryStatus = "Pending";  // Trạng thái giao hàng, mặc định là 'Pending'

    @Column(name = "delivery_date", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp deliveryDate;  // Thời gian giao hàng

    // Constructors
    public Delivery() {}

    public Delivery(String orderId, String deliveryPersonName, String deliveryPersonPhone, String deliveryStatus, Timestamp deliveryDate) {
        this.orderId = orderId;
        this.deliveryPersonName = deliveryPersonName;
        this.deliveryPersonPhone = deliveryPersonPhone;
        this.deliveryStatus = deliveryStatus;
        this.deliveryDate = deliveryDate;
    }

    // Getters and Setters
    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDeliveryPersonName() {
        return deliveryPersonName;
    }

    public void setDeliveryPersonName(String deliveryPersonName) {
        this.deliveryPersonName = deliveryPersonName;
    }

    public String getDeliveryPersonPhone() {
        return deliveryPersonPhone;
    }

    public void setDeliveryPersonPhone(String deliveryPersonPhone) {
        this.deliveryPersonPhone = deliveryPersonPhone;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Timestamp getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Timestamp deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}

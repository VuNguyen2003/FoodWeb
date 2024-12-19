package com.AVfood.foodweb.service;

import com.AVfood.foodweb.exceptions.DeliveryNotFoundException;
import com.AVfood.foodweb.models.Delivery;
import com.AVfood.foodweb.repositories.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    // Tạo hoặc cập nhật Delivery
    public Delivery saveDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    // Lấy Delivery theo ID
    public Delivery getDeliveryById(String deliveryId) {
        Optional<Delivery> delivery = deliveryRepository.findById(deliveryId);
        if (delivery.isEmpty()) {
            throw new DeliveryNotFoundException("Delivery not found with ID: " + deliveryId);
        }
        return delivery.get();
    }

    // Lấy Delivery theo Order ID
    public Delivery getDeliveryByOrderId(String orderId) {
        return deliveryRepository.findByOrderId(orderId);
    }
}

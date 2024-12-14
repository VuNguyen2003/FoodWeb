package com.AVfood.foodweb.repositories;

import com.AVfood.foodweb.models.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, String> {
    // Có thể thêm các phương thức tùy chỉnh nếu cần
    Delivery findByOrderId(String orderId);
}

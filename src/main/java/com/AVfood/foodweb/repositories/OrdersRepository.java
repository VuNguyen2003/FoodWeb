package com.AVfood.foodweb.repositories;

import com.AVfood.foodweb.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, String> {

    // Tìm tất cả các đơn hàng theo trạng thái
    List<Orders> findByStatus(String status);

    // Tìm các đơn hàng theo tên đơn hàng
    List<Orders> findByOrderNameContaining(String orderName);

    // Tìm các đơn hàng đặt trong một khoảng thời gian
    List<Orders> findByOrderDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    // Tìm các đơn hàng chưa có ngày giao
    List<Orders> findByDeliveryDateIsNull();
}

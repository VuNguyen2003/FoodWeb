package com.AVfood.foodweb.repositories;

import com.AVfood.foodweb.models.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Đánh dấu lớp này là Repository của Spring để Spring có thể tự động tạo và inject vào Service
@Repository
public interface OrderStatusRepository extends JpaRepository<OrderStatus, String> {
    List<OrderStatus> findByStatusName(String statusName);

    // JpaRepository đã cung cấp các phương thức CRUD cơ bản, không cần phải định nghĩa lại:
    // - save(): Lưu hoặc cập nhật một đối tượng
    // - findById(): Tìm kiếm đối tượng theo id
    // - findAll(): Lấy tất cả đối tượng
    // - deleteById(): Xóa đối tượng theo id
}

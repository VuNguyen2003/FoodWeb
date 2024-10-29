package com.AVfood.foodweb.repositorys;

import com.AVfood.foodweb.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByProductId(String productId);
    // Có thể thêm các phương thức truy vấn tùy chỉnh tại đây
}

package com.AVfood.foodweb.repositorys;

import com.AVfood.foodweb.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Bạn có thể thêm các phương thức tìm kiếm khác tại đây nếu cần
}

package com.AVfood.foodweb.repositories;

import com.AVfood.foodweb.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    // Phương thức tìm sản phẩm theo khoảng giá
    List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    // Phương thức tìm tất cả sản phẩm và sắp xếp theo giá tăng dần
    List<Product> findAllByOrderByPriceAsc();

    // Phương thức tìm tất cả sản phẩm và sắp xếp theo giá giảm dần
    List<Product> findAllByOrderByPriceDesc();
}

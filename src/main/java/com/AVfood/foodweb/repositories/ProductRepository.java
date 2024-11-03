package com.AVfood.foodweb.repositories;

import com.AVfood.foodweb.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page; // Đảm bảo bạn nhập khẩu từ Spring
import org.springframework.data.domain.Pageable; // Đảm bảo bạn nhập khẩu từ Spring
import org.springframework.data.domain.PageRequest; // Đảm bảo bạn nhập khẩu từ Spring

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    // Phương thức phân trang cho sản phẩm
    Page<Product> findAll(Pageable pageable);

    // Phương thức tìm sản phẩm theo khoảng giá
    List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    // Phương thức tìm tất cả sản phẩm và sắp xếp theo giá tăng dần
    List<Product> findAllByOrderByPriceAsc();

    // Phương thức tìm tất cả sản phẩm và sắp xếp theo giá giảm dần
    List<Product> findAllByOrderByPriceDesc();

    @Query("SELECT p FROM Product p WHERE LOWER(p.productName) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Product> findByProductNameContainingIgnoreCase(@Param("name") String name);
}

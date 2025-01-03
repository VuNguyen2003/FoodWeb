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

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByProductNameContainingIgnoreCase(String name);
    List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
    List<Product> findAllByOrderByPriceAsc();
    List<Product> findAllByOrderByPriceDesc();

}


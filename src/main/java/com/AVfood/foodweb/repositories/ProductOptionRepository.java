package com.AVfood.foodweb.repositories;

import com.AVfood.foodweb.models.ProductOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductOptionRepository extends JpaRepository<ProductOption, String> {
    List<ProductOption> findByProductId(String productId);

    @Query("SELECT p FROM ProductOption p WHERE p.product.id = :productId")
    List<ProductOption> findByProductId(@Param("productId") Long productId);

}


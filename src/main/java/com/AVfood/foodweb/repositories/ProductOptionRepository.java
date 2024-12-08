package com.AVfood.foodweb.repositories;

import com.AVfood.foodweb.models.ProductOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductOptionRepository extends JpaRepository<ProductOption, String> {
    List<ProductOption> findByProductId(String productId);
}


package com.AVfood.foodweb.services;

import com.AVfood.foodweb.models.ProductOption;
import com.AVfood.foodweb.repositories.ProductOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOptionService {
    @Autowired
    private ProductOptionRepository productOptionRepository;

    public List<ProductOption> getProductOptions(String productId) {
        return productOptionRepository.findByProductId(productId);
    }
}


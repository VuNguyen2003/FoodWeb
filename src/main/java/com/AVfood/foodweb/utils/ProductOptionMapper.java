package com.AVfood.foodweb.utils;

import com.AVfood.foodweb.dtos.request.ProductOptionRequest;
import com.AVfood.foodweb.dtos.response.ProductOptionResponse;
import com.AVfood.foodweb.models.ProductOption;

public class ProductOptionMapper {

    public static ProductOption toEntity(ProductOptionRequest request) {
        return new ProductOption(null, request.getProductId(), request.getOptionCategoryId());
    }

    public static ProductOptionResponse toDTO(ProductOption productOption) {
        return new ProductOptionResponse(
                productOption.getProductOptionId(),
                productOption.getProductId(),
                productOption.getOptionCategoryId()
        );
    }
}

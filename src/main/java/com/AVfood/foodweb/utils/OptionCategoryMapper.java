package com.AVfood.foodweb.utils;

import com.AVfood.foodweb.dtos.request.OptionCategoryRequest;
import com.AVfood.foodweb.dtos.response.OptionCategoryRespone;
import com.AVfood.foodweb.models.OptionCategory;

public class OptionCategoryMapper {
    public static OptionCategoryRespone toDTO(OptionCategory entity) {
        OptionCategoryRespone dto = new OptionCategoryRespone();
        dto.setCategoryName(entity.getCategoryName());
        return dto;
    }

    public static OptionCategory toEntity(OptionCategoryRequest dto) {
        OptionCategory entity = new OptionCategory();
        entity.setCategoryName(dto.getCategoryName());
        return entity;
    }
}

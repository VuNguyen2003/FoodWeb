package com.AVfood.foodweb.utils;

import com.AVfood.foodweb.dtos.request.OptionRequest;
import com.AVfood.foodweb.dtos.response.OptionResponse;
import com.AVfood.foodweb.models.Option;

public class OptionMapper {

    public static Option toEntity(OptionRequest request) {
        return new Option(null, request.getOptionCategoryId(), request.getOptionName(), request.getAdditionalPrice());
    }

    public static OptionResponse toDTO(Option option) {
        return new OptionResponse(option.getOptionId(), option.getOptionCategoryId(), option.getOptionName(), option.getAdditionalPrice());
    }
}

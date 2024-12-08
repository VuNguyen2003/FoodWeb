package com.AVfood.foodweb.services;

import com.AVfood.foodweb.models.Option;
import com.AVfood.foodweb.repositories.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OptionService {
    @Autowired
    private OptionRepository optionRepository;

    // Lấy danh sách Option dựa trên Category ID
    public List<Option> getOptionsByCategory(String categoryId) {
        return optionRepository.findByOptionCategoryId(categoryId);
    }

    // Lấy Option theo ID
    public Optional<Option> getOptionById(String optionId) {
        return optionRepository.findById(optionId); // Gọi repository để tìm kiếm
    }
}

package com.AVfood.foodweb.services;

import com.AVfood.foodweb.dtos.request.OptionRequest;
import com.AVfood.foodweb.dtos.response.OptionResponse;
import com.AVfood.foodweb.exceptions.ResourceNotFoundException;
import com.AVfood.foodweb.models.Option;
import com.AVfood.foodweb.repositories.OptionRepository;
import com.AVfood.foodweb.utils.OptionMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OptionService {

    private final OptionRepository repository;

    public OptionService(OptionRepository repository) {
        this.repository = repository;
    }

    public List<OptionResponse> getAllOptions() {
        return repository.findAll().stream()
                .map(OptionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public OptionResponse getOptionById(String id) {
        Option option = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Option not found with id: " + id));
        return OptionMapper.toDTO(option);
    }

    public OptionResponse createOption(OptionRequest request) {
        Option option = OptionMapper.toEntity(request);
        Option savedOption = repository.save(option);
        return OptionMapper.toDTO(savedOption);
    }

    public OptionResponse updateOption(String id, OptionRequest request) {
        Option existingOption = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Option not found with id: " + id));
        existingOption.setOptionCategoryId(request.getOptionCategoryId());
        existingOption.setOptionName(request.getOptionName());
        existingOption.setAdditionalPrice(request.getAdditionalPrice());
        Option updatedOption = repository.save(existingOption);
        return OptionMapper.toDTO(updatedOption);
    }

    public void deleteOption(String id) {
        Option existingOption = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Option not found with id: " + id));
        repository.delete(existingOption);
    }
}

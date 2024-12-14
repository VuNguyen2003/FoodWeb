package com.AVfood.foodweb.services;

import com.AVfood.foodweb.dtos.request.OrderDetailsOptionRequest;
import com.AVfood.foodweb.dtos.response.OrderDetailsOptionResponse;
import com.AVfood.foodweb.exceptions.ResourceNotFoundException;
import com.AVfood.foodweb.models.OrderDetailsOption;
import com.AVfood.foodweb.repositories.OrderDetailsOptionRepository;
import com.AVfood.foodweb.utils.OrderDetailsOptionMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderDetailsOptionService {

    private final OrderDetailsOptionRepository repository;

    public OrderDetailsOptionService(OrderDetailsOptionRepository repository) {
        this.repository = repository;
    }

    public List<OrderDetailsOptionResponse> getAllOrderDetailsOptions() {
        return repository.findAll().stream()
                .map(OrderDetailsOptionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public OrderDetailsOptionResponse getOrderDetailsOptionById(String id) {
        OrderDetailsOption entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrderDetailsOption not found with id: " + id));
        return OrderDetailsOptionMapper.toDTO(entity);
    }

    public OrderDetailsOptionResponse createOrderDetailsOption(OrderDetailsOptionRequest request) {
        OrderDetailsOption entity = OrderDetailsOptionMapper.toEntity(request);
        OrderDetailsOption savedEntity = repository.save(entity);
        return OrderDetailsOptionMapper.toDTO(savedEntity);
    }

    public OrderDetailsOptionResponse updateOrderDetailsOption(String id, OrderDetailsOptionRequest request) {
        OrderDetailsOption existingEntity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrderDetailsOption not found with id: " + id));
        existingEntity.setOrderDetailId(request.getOrderDetailId());
        existingEntity.setOptionId(request.getOptionId());
        OrderDetailsOption updatedEntity = repository.save(existingEntity);
        return OrderDetailsOptionMapper.toDTO(updatedEntity);
    }

    public void deleteOrderDetailsOption(String id) {
        OrderDetailsOption existingEntity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrderDetailsOption not found with id: " + id));
        repository.delete(existingEntity);
    }
}

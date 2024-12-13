package com.AVfood.foodweb.services;

import com.AVfood.foodweb.dtos.request.OrderStatusRequest;
import com.AVfood.foodweb.dtos.response.OrderStatusResponse;
import com.AVfood.foodweb.exceptions.ResourceNotFoundException;
import com.AVfood.foodweb.models.OrderStatus;
import com.AVfood.foodweb.repositories.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderStatusService {

    private final OrderStatusRepository orderStatusRepository;

    @Autowired
    public OrderStatusService(OrderStatusRepository orderStatusRepository) {
        this.orderStatusRepository = orderStatusRepository;
    }

    public OrderStatusResponse createOrderStatus(OrderStatusRequest requestDTO) {
        OrderStatus orderStatus = new OrderStatus(requestDTO.getStatusId(), requestDTO.getStatusName());
        orderStatus = orderStatusRepository.save(orderStatus);
        return new OrderStatusResponse(orderStatus.getStatusId(), orderStatus.getStatusName());
    }

    public List<OrderStatusResponse> getAllOrderStatuses() {
        List<OrderStatus> orderStatuses = orderStatusRepository.findAll();
        return orderStatuses.stream()
                .map(orderStatus -> new OrderStatusResponse(orderStatus.getStatusId(), orderStatus.getStatusName()))
                .toList();
    }

    public OrderStatusResponse getOrderStatusById(String statusId) {
        Optional<OrderStatus> orderStatusOpt = orderStatusRepository.findById(statusId);
        if (orderStatusOpt.isEmpty()) {
            return null;  // Trả về null để controller xử lý
        }
        OrderStatus orderStatus = orderStatusOpt.get();
        return new OrderStatusResponse(orderStatus.getStatusId(), orderStatus.getStatusName());
    }

    public OrderStatusResponse updateOrderStatus(String statusId, OrderStatusRequest requestDTO) {
        Optional<OrderStatus> orderStatusOpt = orderStatusRepository.findById(statusId);
        if (orderStatusOpt.isEmpty()) {
            throw new ResourceNotFoundException("OrderStatus with ID " + statusId + " not found.");
        }
        OrderStatus orderStatus = orderStatusOpt.get();
        orderStatus.setStatusName(requestDTO.getStatusName());
        orderStatus = orderStatusRepository.save(orderStatus);
        return new OrderStatusResponse(orderStatus.getStatusId(), orderStatus.getStatusName());
    }

    public void deleteOrderStatus(String statusId) {
        Optional<OrderStatus> orderStatusOpt = orderStatusRepository.findById(statusId);
        if (orderStatusOpt.isEmpty()) {
            throw new ResourceNotFoundException("OrderStatus with ID " + statusId + " not found.");
        }
        orderStatusRepository.deleteById(statusId);
    }
}

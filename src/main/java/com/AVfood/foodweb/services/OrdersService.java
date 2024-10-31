package com.AVfood.foodweb.services;

import com.AVfood.foodweb.exceptions.OrderNotFoundException;
import com.AVfood.foodweb.models.Orders;
import com.AVfood.foodweb.repositories.OrdersRepository;
import com.AVfood.foodweb.dtos.request.OrdersRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository repository;

    public List<Orders> getAllOrders() {
        return repository.findAll();
    }

    public Orders getOrderById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id " + id));
    }

    public Orders createOrder(OrdersRequest dto) {
        Orders order = new Orders(
                dto.getOrderId(),
                dto.getStatusId(),
                dto.getOrderName()
        );
        return repository.save(order);
    }

    public Orders updateOrder(String id, OrdersRequest dto) {
        Orders order = getOrderById(id);
        order.setStatusId(dto.getStatusId());
        order.setOrderName(dto.getOrderName());
        return repository.save(order);
    }

    public void deleteOrder(String id) {
        if (!repository.existsById(id)) {
            throw new OrderNotFoundException("Order not found with id " + id);
        }
        repository.deleteById(id);
    }
}

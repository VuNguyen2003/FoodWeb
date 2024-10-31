package com.AVfood.foodweb.services;

import com.AVfood.foodweb.exceptions.OrderDetailNotFoundException;
import com.AVfood.foodweb.models.OrderDetails;
import com.AVfood.foodweb.repositorys.OrderDetailsRepository;
import com.AVfood.foodweb.dto.request.OrderDetailsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService {

    @Autowired
    private OrderDetailsRepository repository;

    public List<OrderDetails> getAllOrderDetails() {
        return repository.findAll();
    }

    public OrderDetails getOrderDetailById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new OrderDetailNotFoundException("Order detail not found with id " + id));
    }

    public OrderDetails createOrderDetail(OrderDetailsRequest dto) {
        OrderDetails orderDetail = new OrderDetails(
                dto.getOrderDetailId(),
                dto.getProductId(),
                dto.getOrderId(),
                dto.getOrderQuantity(),
                dto.getOrderTotal()
        );
        return repository.save(orderDetail);
    }

    public OrderDetails updateOrderDetail(String id, OrderDetailsRequest dto) {
        OrderDetails orderDetail = getOrderDetailById(id);
        orderDetail.setProductId(dto.getProductId());
        orderDetail.setOrderId(dto.getOrderId());
        orderDetail.setOrderQuantity(dto.getOrderQuantity());
        orderDetail.setOrderTotal(dto.getOrderTotal());
        return repository.save(orderDetail);
    }

    public void deleteOrderDetail(String id) {
        if (!repository.existsById(id)) {
            throw new OrderDetailNotFoundException("Order detail not found with id " + id);
        }
        repository.deleteById(id);
    }
}

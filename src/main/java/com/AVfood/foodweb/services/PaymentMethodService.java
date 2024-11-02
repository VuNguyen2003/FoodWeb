package com.AVfood.foodweb.services;

import com.AVfood.foodweb.dtos.PaymentMethodRequest;
import com.AVfood.foodweb.exceptions.PaymentMethodNotFoundException;
import com.AVfood.foodweb.models.PaymentMethod;
import com.AVfood.foodweb.repositories.PaymentMethodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentMethodService {

    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodService(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    public PaymentMethod createPaymentMethod(PaymentMethodRequest request) {
        PaymentMethod paymentMethod = new PaymentMethod(request.getPaymentMethodId(), request.getPaymentMethodName());
        return paymentMethodRepository.save(paymentMethod);
    }

    public PaymentMethod getPaymentMethodById(String id) {
        return paymentMethodRepository.findById(id)
                .orElseThrow(() -> new PaymentMethodNotFoundException("Payment method not found with id " + id));
    }

    public List<PaymentMethod> getAllPaymentMethods() {
        return paymentMethodRepository.findAll();
    }

    public PaymentMethod updatePaymentMethod(String id, PaymentMethodRequest request) {
        PaymentMethod paymentMethod = getPaymentMethodById(id);
        paymentMethod.setPaymentMethodName(request.getPaymentMethodName());
        return paymentMethodRepository.save(paymentMethod);
    }

    public void deletePaymentMethod(String id) {
        PaymentMethod paymentMethod = getPaymentMethodById(id);
        paymentMethodRepository.delete(paymentMethod);
    }
}

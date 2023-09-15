package com.foxdev.hexagonal.application;

import com.foxdev.hexagonal.domain.model.Orders;
import com.foxdev.hexagonal.infrastructure.inputport.OrderInputPort;
import com.foxdev.hexagonal.infrastructure.outputport.EntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrdersUseCase implements OrderInputPort {

    private final EntityRepository entityRepository;

    @Override
    public Orders createOrder(String customerId, Double amount) {
        Orders order= Orders.builder()
                .customerId(customerId)
                .amount(amount)
                .build();
        return entityRepository.Save(order);
    }
}

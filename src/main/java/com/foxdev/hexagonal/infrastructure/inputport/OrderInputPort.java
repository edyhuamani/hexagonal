package com.foxdev.hexagonal.infrastructure.inputport;

import com.foxdev.hexagonal.domain.model.Orders;

public interface OrderInputPort {
    Orders createOrder(String customerId, Double total);
}

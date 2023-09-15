package com.foxdev.hexagonal.infrastructure.inputadapter;

import com.foxdev.hexagonal.domain.model.Orders;
import com.foxdev.hexagonal.infrastructure.inputport.OrderInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrdersAPI {
    private final OrderInputPort orderInputPort;
    @PostMapping(value = "/create")
    public Orders create(@RequestParam String customerId,@RequestParam Double amount){
        return orderInputPort.createOrder(customerId,amount);
    }


}

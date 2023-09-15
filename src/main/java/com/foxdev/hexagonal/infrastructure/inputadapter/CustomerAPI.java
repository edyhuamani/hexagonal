package com.foxdev.hexagonal.infrastructure.inputadapter;

import com.foxdev.hexagonal.domain.model.Customer;
import com.foxdev.hexagonal.infrastructure.inputport.CustomerInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerAPI {

    private final CustomerInputPort customerInputPort;
    @PostMapping(value = "/create")
    public Customer create(@RequestBody Customer customer) {
        return customerInputPort.createCustomer(customer);
    }

}

package com.foxdev.hexagonal.infrastructure.inputadapter;

import com.foxdev.hexagonal.domain.model.Customer;
import com.foxdev.hexagonal.infrastructure.inputport.CustomerInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerAPI {

    private final CustomerInputPort customerInputPort;
    @PostMapping(value = "/create",produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer create(@RequestBody Customer customer) {
        return customerInputPort.createCustomer(customer);
    }
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer get(@RequestParam String customerId){
        return customerInputPort.getById(customerId);
    }

}

package com.foxdev.hexagonal.infrastructure.inputport;

import com.foxdev.hexagonal.domain.model.Customer;

import java.util.List;

public interface CustomerInputPort {
    Customer createCustomer(Customer customer);
    Customer getById(String customerId);
    List<Customer> getAll();
}

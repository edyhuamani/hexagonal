package com.foxdev.hexagonal.application;

import com.foxdev.hexagonal.domain.model.Customer;
import com.foxdev.hexagonal.infrastructure.inputport.CustomerInputPort;
import com.foxdev.hexagonal.infrastructure.outputport.EntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerUseCase implements CustomerInputPort {

    private  final EntityRepository entityRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        return entityRepository.Save(customer);
    }

    @Override
    public Customer getById(String customerId) {
        return entityRepository.getById(customerId);
    }

    @Override
    public List<Customer> getAll() {
        return null;
    }
}

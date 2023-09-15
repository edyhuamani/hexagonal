package com.foxdev.hexagonal.domain.repository;

import com.foxdev.hexagonal.domain.model.Bank;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BankRepository extends ReactiveCrudRepository<Bank,String> {
}

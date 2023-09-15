package com.foxdev.hexagonal.domain.repository;

import com.foxdev.hexagonal.domain.model.Transaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;


/**
 *
 */
@Repository
public interface TransactionRepository extends ReactiveCrudRepository<Transaction, String> {

}

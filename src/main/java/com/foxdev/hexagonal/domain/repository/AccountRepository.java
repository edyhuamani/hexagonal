package com.foxdev.hexagonal.domain.repository;

import com.foxdev.hexagonal.domain.model.Account;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface AccountRepository extends ReactiveCrudRepository<Account,String> {

}

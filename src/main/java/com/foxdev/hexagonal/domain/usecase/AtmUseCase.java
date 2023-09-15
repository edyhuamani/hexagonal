package com.foxdev.hexagonal.domain.usecase;

import com.foxdev.hexagonal.domain.model.Person;
import com.foxdev.hexagonal.domain.repository.AccountRepository;
import com.foxdev.hexagonal.domain.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AtmUseCase {

    private final AccountRepository accountRepository;

    private final BankRepository bankRepository;

    public double withDrawal(double amount , Person customer){

        return 0;
    }

    public double payment(double amount , Person customer){
        return 0;
    }


}

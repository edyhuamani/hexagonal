package com.foxdev.hexagonal.domain.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class Transaction {
    @Id
    private String id;
    private Double amount;
}

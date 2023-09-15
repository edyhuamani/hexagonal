package com.foxdev.hexagonal.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Orders {
    private String customerId;
    private Double amount;
}

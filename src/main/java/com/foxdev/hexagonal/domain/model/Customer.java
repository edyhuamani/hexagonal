package com.foxdev.hexagonal.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class Customer {
    private String id;
    private String name;
    private String country;
}

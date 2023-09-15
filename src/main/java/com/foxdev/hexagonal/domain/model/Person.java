package com.foxdev.hexagonal.domain.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@RequiredArgsConstructor
public class Person {
    @Id
    private String id;
    private String firstName;
    private String lastName;
}

package com.foxdev.hexagonal.infrastructure.outputport;

import java.util.List;

public interface EntityRepository {
    <T> T Save(T reg);
    <T> T getById(String id);
    <T> List<T> getAll( Class<T> clazz);
}

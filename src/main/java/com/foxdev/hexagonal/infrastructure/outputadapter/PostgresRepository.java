package com.foxdev.hexagonal.infrastructure.outputadapter;

import com.foxdev.hexagonal.infrastructure.outputport.EntityRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PostgresRepository implements EntityRepository {
    @Override
    public <T> T Save(T reg) {
        return null;
    }

    @Override
    public <T> T getById(String id) {
        return null;
    }

    @Override
    public <T> List<T> getAll(Class<T> clazz) {
        return null;
    }
}

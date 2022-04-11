package com.example.practice.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface BaseDao<T> {

    public T save(T type);

    public T findById(UUID id);

    public List<T> findAll();

    public T deleteById(UUID id);

}

package com.github.siwonpawel.similarity.data.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.List;

@NoRepositoryBean
public interface LimitedRepository<T, I> extends Repository<T, I> {

    T save(T entity);

    List<T> findAll();
}
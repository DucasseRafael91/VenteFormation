package com.venteformation.daos;

import java.util.List;

public interface Dao<T> {

    void create(T obj);

    void update(T obj);

    void delete(int id);

    T findById(int id);

    List<T> findAll();
}


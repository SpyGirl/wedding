package com.wedding.dao;

import java.util.List;

public interface BaseDao {

    <T> List<T> getAll(Class<T> entity);
    <T> T findById(Class<T> entity, int id);
    <T> void merge(T obj);
    <T> void deleteById(Class<T> entity, int id);
}

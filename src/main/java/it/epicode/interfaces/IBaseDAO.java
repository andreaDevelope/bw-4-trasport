package it.epicode.interfaces;

import java.util.List;

public interface IBaseDAO<T> {
    void create(T entity);

    T read(Long id);

    void update(T entity);

    void delete(Long id);

    List<T> findAll();
}

package dao;

import java.util.Collection;

public interface GenericDao<T> {
    T findItem(String id);
    Collection<T> findAll();
    void addItem(T item);
    void updateItem(T item);
    void deleteItem(String id);
}

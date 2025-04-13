package businness.dao;

import java.util.List;

public interface AppDAO<T, K> {
    List<T> findAll();
    T findById(K id);
    boolean insert(T t);
    boolean update(T t);
    boolean delete(K id);
}
package operations;

import java.util.List;

public interface CrudOperations <T>{
    List<T> findAll();
    List<T> saveAll(List<T> entity);
    T save(T entity);
    void delete(int id);
}

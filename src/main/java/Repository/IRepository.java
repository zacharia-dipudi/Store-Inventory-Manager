package Repository;

/* IRepository.java
IRepository class
Author: Jayden Avontuur (222032278)
Date: 21 March 2026*/

import java.util.Set;

public interface IRepository<T, ID> {
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
    Set<T> getAll();
}

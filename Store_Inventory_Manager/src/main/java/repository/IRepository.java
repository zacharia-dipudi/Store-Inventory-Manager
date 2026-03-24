/*Author : Zacharia dipidi
Date: 24 march 2026
 */
package repository;

public interface IRepository <T, ID> {
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
}

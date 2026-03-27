/*Author : Zacharia dipidi
Date: 24 march 2026
 */
package repository;

import Domain.Product;

import java.util.List;

public interface IProductRepository extends IRepository<Product, String> {
    List<Product>getAll();
}

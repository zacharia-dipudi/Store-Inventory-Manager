/*Author : Zacharia dipidi
Date: 24 march 2026
 */
package repository;

import Domain.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository{
    private static IProductRepository repository= null;
    private List<Product>productList;

    private ProductRepository(){
      productList = new ArrayList<>();
    }
    public static IProductRepository getRepository(){
       if(repository == null){
           repository = new ProductRepository();

       }
       return repository;
    }


    @Override
    public Product create(Product product) {
        boolean success = productList.add(product);
        if(success){
            return product;
        }
        return null;
    }

    @Override
    public Product read(String productId) {
        for (Product product : productList) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
            return null;

    }

    @Override
    public Product update(Product product) {
        String id = product.getProductId();
        Product oldProduct = read(id);

        if(oldProduct == null){
            return null;
        }
        boolean success = productList.remove(oldProduct);
        if(!success){
            return null;
        }
        if(productList.add(product)){
            return product;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Product productToDelete  = read(id);
        if(productToDelete == null){
            return false;
        }
        return(productList.remove(productToDelete));
    }
    @Override
    public List<Product> getAll() {
        return productList;
    }
}

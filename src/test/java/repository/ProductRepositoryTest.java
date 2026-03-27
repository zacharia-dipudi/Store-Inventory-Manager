/*Author : Zacharia dipidi
Date: 24 march 2026
 */
package repository;

import Domain.Product;
import Factory.productFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private IProductRepository repository;
    private Product product;

    @BeforeEach
    void setUp() {
        repository = ProductRepository.getRepository();

        repository.getAll().clear();

        product = productFactory.createProduct(
                "1234",
                "iPhone 17",
                "Pro Max",
                "R29000"
        );
    }

    @Test
    void create() {
        Product created = repository.create(product);
        assertNotNull(created);
        }


    @Test
    void read() {
        repository.create(product);
        Product read = repository.read("1234");

                assertNotNull(product);
                assertEquals("1234",read.getProductId());

    }

    @Test
    void update() {
        repository.create(product);

        Product updated =new Product.Builder()
                .copy(product)
                .setProductName("Iphone17")
                .build();
        Product results = repository.update(updated);

        assertNotNull(results);
        assertEquals("Iphone17",results.getProductName());
    }

    @Test
    void delete() {
        repository.create(product);

        boolean deleted = repository.delete("1234");
        assertTrue(deleted);
    }

    @Test
    void getAll() {
        repository.create(product);
        assertFalse(repository.getAll().isEmpty());
    }
}
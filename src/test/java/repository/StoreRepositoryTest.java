/*Author : Zacharia dipidi
Date: 24 march 2026
 */
package repository;

import Domain.Product;
import Domain.Store;
import Factory.StoreFactory;
import Factory.productFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreRepositoryTest {
    private IStoreRepository repository;
    private Store store;

    @BeforeEach
    void setUp() {
        repository = StoreRepository.getRepository();

        repository.getAll().clear();

        Product product = productFactory.createProduct(
                "P001",
                "iPhone 17",
                "Pro Max",
                "R29000"
        );


        store = StoreFactory.createStore(
                "410",
                "Istore",
                "0114101754",
                "cape town",
                  product
        );
    }
    @Test
    void create() {
        Store created = repository.create(store);
        assertNotNull(created);
    }

    @Test
    void read() {
        repository.create(store);
        Store read = repository.read("410");
        assertNotNull(read);
        assertEquals("410", read.getStoreId());
    }

    @Test
    void update() {
        repository.create(store);

        Store updated = new Store.Builder()
                .copy(store)
                .setStoreName ("Istore updated")
                .Build();
        Store results = repository.update(updated);

        assertNotNull(results);
        assertEquals("Istore updated",results.getStoreName());

    }

    @Test
    void delete() {
        repository.create(store);

        boolean deleted = repository.delete("410");

        assertTrue(deleted);
    }

    @Test
    void getAll() {
        repository.create(store);

        assertFalse(repository.getAll().isEmpty());
    }
}
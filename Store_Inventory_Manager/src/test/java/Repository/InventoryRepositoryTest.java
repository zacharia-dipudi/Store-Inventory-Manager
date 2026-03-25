package Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Domain.*;
import Factory.InventoryFactory;
import Repository.InventoryRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

class InventoryRepositoryTest {

    private InventoryRepository repository;
    private Inventory inventory;
    private Product product;

    @BeforeEach
    void setUp() {
        repository = InventoryRepositoryImpl.getRepository();

        // Dummy product (must exist in your domain)
        product = new Product.Builder("P01", "Laptop").build();

        inventory = InventoryFactory.createInventory(
                "I01",
                product,
                null,
                null,
                10,
                5,
                50,
                15000.0,
                "A1"
        );
    }

    @Test
    void create() {
        Inventory created = repository.create(inventory);
        assertNotNull(created);
        assertEquals(inventory.getInventoryId(), created.getInventoryId());
    }

    @Test
    void read() {
        repository.create(inventory);
        Inventory read = repository.read("I01");
        assertNotNull(read);
    }

    @Test
    void update() {
        repository.create(inventory);

        Inventory updatedInventory = new Inventory.Builder("I01", product)
                .setQuantityInStock(20)
                .setUnitPrice(20000.0)
                .build();

        Inventory updated = repository.update(updatedInventory);
        assertNotNull(updated);
        assertEquals(20, updated.getQuantityInStock());
    }

    @Test
    void delete() {
        repository.create(inventory);
        boolean deleted = repository.delete("I01");
        assertTrue(deleted);
    }

    @Test
    void getAll() {
        repository.create(inventory);
        assertFalse(repository.getAll().isEmpty());
    }
}

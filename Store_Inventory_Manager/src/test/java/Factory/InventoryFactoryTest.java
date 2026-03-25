package Factory;

import org.junit.jupiter.api.Test;
import Domain.*;

import static org.junit.jupiter.api.Assertions.*;

class InventoryFactoryTest {

    @Test
    void createInventory_success() {

        Product product = new Product.Builder("P01", "Laptop").build();

        Inventory inventory = InventoryFactory.createInventory(
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

        assertNotNull(inventory);
        assertEquals("I01", inventory.getInventoryId());
        assertEquals(10, inventory.getQuantityInStock());
        assertEquals(15000.0, inventory.getUnitPrice());
    }

    @Test
    void createInventory_nullId() {

        Product product = new Product.Builder("P01", "Laptop").build();

        Inventory inventory = InventoryFactory.createInventory(
                null,
                product,
                null,
                null,
                10,
                5,
                50,
                15000.0,
                "A1"
        );

        assertNull(inventory);
    }

    @Test
    void createInventory_nullProduct() {

        Inventory inventory = InventoryFactory.createInventory(
                "I01",
                null,
                null,
                null,
                10,
                5,
                50,
                15000.0,
                "A1"
        );

        assertNull(inventory);
    }

    @Test
    void createInventory_negativeValues() {

        Product product = new Product.Builder("P01", "Laptop").build();

        Inventory inventory = InventoryFactory.createInventory(
                "I01",
                product,
                null,
                null,
                -5,
                5,
                50,
                -100.0,
                "A1"
        );

        assertNull(inventory);
    }
}

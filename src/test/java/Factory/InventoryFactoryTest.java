package Factory;

/* InventoryFactoryTest.java
InventoryFactoryTest class
Author: Jayden Avontuur (222032278)
Date: 21 March 2026*/

import org.junit.jupiter.api.Test;
import Domain.*;
import Factory.CategoryFactory;

import static org.junit.jupiter.api.Assertions.*;

class InventoryFactoryTest {

    private final Product product = new Product.Builder("P01", "Laptop").build();
    private final Category category = CategoryFactory.createCategory("C01", "Electronics", "Devices and gadgets");
    private final Supplier supplier = new Supplier.Builder("S01", "TechSupply").build();

    @Test
    void createInventory_success() {
        Inventory inventory = InventoryFactory.createInventory(
                "I01", product, category, supplier,
                10, 5, 50, 15000.0, "A1");

        assertNotNull(inventory);
        assertEquals("I01", inventory.getInventoryId());
        assertEquals(10, inventory.getQuantityInStock());
        assertEquals(15000.0, inventory.getUnitPrice());
    }

    @Test
    void createInventory_nullId() {
        Inventory inventory = InventoryFactory.createInventory(
                null, product, category, supplier,
                10, 5, 50, 15000.0, "A1");

        assertNull(inventory);
    }

    @Test
    void createInventory_nullProduct() {
        Inventory inventory = InventoryFactory.createInventory(
                "I01", null, category, supplier,
                10, 5, 50, 15000.0, "A1");

        assertNull(inventory);
    }

    @Test
    void createInventory_negativeValues() {
        Inventory inventory = InventoryFactory.createInventory(
                "I01", product, category, supplier,
                -5, 5, 50, -100.0, "A1");

        assertNull(inventory);
    }
}
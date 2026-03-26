package Factory;

/* InventoryFactory.java
InventoryFactory class
Author: Jayden Avontuur (222032278)
Date: 19 March 2026*/

import Domain.Inventory;
import Domain.Category;
import Util.Helper;

import java.time.LocalDate;

public class InventoryFactory {

    public static Inventory createInventory(String inventoryId, Product product, Category category, Supplier supplier, int quantityInStock, int minimumStockLevel, int maximumStockLevel, double unitPrice, String location) {
        if (Helper.isNullOrEmpty(inventoryId) || product == null || category == null || supplier == null || !Helper.isValidQuantity(quantityInStock) || !Helper.isValidStockLevels(minimumStockLevel, maximumStockLevel) || !Helper.isValidPrice(unitPrice) || Helper.isNullOrEmpty(location)) {
            return null;
        }

        return new Inventory.Builder(inventoryId, product)
                .setCategory(category)
                .setSupplier(supplier)
                .setQuantityInStock(quantityInStock)
                .setMinimumStockLevel(minimumStockLevel)
                .setMaximumStockLevel(maximumStockLevel)
                .setUnitPrice(unitPrice)
                .setLastRestockedDate(LocalDate.now())
                .setLocation(location)
                .build();
    }
}

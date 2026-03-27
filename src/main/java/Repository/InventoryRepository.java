package Repository;

/* InventoryRepository.java
InventoryRepository class
Author: Jayden Avontuur (222032278)
Date: 21 March 2026*/

import Domain.Inventory;

import java.util.HashSet;
import java.util.Set;

public class InventoryRepository implements IInventoryRepository {

    private static InventoryRepository repository = null;
    private Set<Inventory> inventoryDB;

    private InventoryRepository() {
        inventoryDB = new HashSet<>();
    }

    public static InventoryRepository getRepository() {
        if (repository == null) {
            repository = new InventoryRepository();
        }
        return repository;
    }

    @Override
    public Inventory create(Inventory inventory) {
        inventoryDB.add(inventory);
        return inventory;
    }

    @Override
    public Inventory read(String inventoryId) {
        for (Inventory inv : inventoryDB) {
            if (inv.getInventoryId().equals(inventoryId)) {
                return inv;
            }
        }
        return null;
    }

    @Override
    public Inventory update(Inventory inventory) {
        Inventory oldInventory = read(inventory.getInventoryId());
        if (oldInventory != null) {
            inventoryDB.remove(oldInventory);
            inventoryDB.add(inventory);
            return inventory;
        }
        return null;
    }

    @Override
    public boolean delete(String inventoryId) {
        Inventory inventory = read(inventoryId);
        if (inventory != null) {
            inventoryDB.remove(inventory);
            return true;
        }
        return false;
    }

    @Override
    public Set<Inventory> getAll() {
        return inventoryDB;
    }
}
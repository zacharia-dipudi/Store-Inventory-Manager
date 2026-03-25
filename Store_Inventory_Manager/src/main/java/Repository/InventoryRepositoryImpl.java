package Repository;

import Domain.Inventory;
import Repository.InventoryRepository;

import java.util.HashSet;
import java.util.Set;

public class InventoryRepositoryImpl implements InventoryRepository {

    private static InventoryRepositoryImpl repository = null;
    private Set<Inventory> inventoryDB;

    private InventoryRepositoryImpl() {
        inventoryDB = new HashSet<>();
    }

    public static InventoryRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new InventoryRepositoryImpl();
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
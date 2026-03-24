/*Author : Zacharia dipidi
Date: 24 march 2026
 */
package repository;

import Domain.Product;
import Domain.Store;

import java.util.ArrayList;
import java.util.List;

public class StoreRepository implements IStoreRepository{
    private static IStoreRepository repository = null;
    private List<Store>storeList;

    private StoreRepository() {
        storeList = new ArrayList<>();
    }
    public static IStoreRepository getRepository() {
        if (repository == null){
            repository = new StoreRepository();
        }

            return repository;
    }

    @Override
    public Store create(Store store) {
       boolean success = storeList.add(store);
       if(success){
           return store;
       }
        return null;
    }

    @Override
    public Store read(String storeId) {
        for(Store store : storeList){
            if(store.getStoreId().equals(storeId)){
                return store;
            }

        }
        return null;
    }

    @Override
    public Store update(Store store) {
        String id = store.getStoreId();
        Store oldStore = read(id);

        if(oldStore == null){
            return null;
        }
       boolean success = storeList.remove(oldStore);
        if(!success){
            return null;
        }
        if(storeList.add(store)){
            return store;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Store storeToDelete = read(id);
        if(storeToDelete == null) {
            return false;
        }
        return storeList.remove(storeToDelete);
    }
    @Override
    public List<Store> getAll() {
        return storeList;
    }
}

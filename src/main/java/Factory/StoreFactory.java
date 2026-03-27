/*Author : Zacharia dipidi
Date: 24 march 2026
 */
package Factory;

import Domain.Product;
import Domain.Store;
import Util.Helper;

public class StoreFactory {
public static Store createStore(String storeId, String storeName, String storePhoneNumber, String storeLocation, Product product){

    if(Helper.isNullOrEmpty(storeId)
        || Helper.isNullOrEmpty(storeName)
        || Helper.isNullOrEmpty(storePhoneNumber)
        || Helper.isNullOrEmpty(storeLocation)
        || product == null){

        return null;
    }
    return new Store.Builder()
            .setStoreId( storeId)
            .setStoreName( storeName)
            .setStorePhoneNumber(storePhoneNumber)
            .setStoreLocation(storeLocation)
            .setProduct(product)
            .Build();



}
}

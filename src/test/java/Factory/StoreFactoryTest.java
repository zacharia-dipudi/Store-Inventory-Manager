/*Author : Zacharia dipidi
Date: 24 march 2026
 */
package Factory;

import Domain.Product;
import Domain.Store;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreFactoryTest {

    @Test
    void createStore() {
        Product product = productFactory.createProduct("1234","Iphone 17", "Pro max", "R29000");
        Store store = StoreFactory.createStore("410","Istore","0114101754","cape town",product);
        assertNotNull(store);
        assertNotNull(store.getProduct());
        System.out.println(store);
    }
}
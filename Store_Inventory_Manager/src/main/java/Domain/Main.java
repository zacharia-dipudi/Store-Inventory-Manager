/*Author : Zacharia dipidi
Date: 24 march 2026
 */
package Domain;

import Factory.StoreFactory;
import Factory.productFactory;

public class Main {
   public static void main(String[] args) {

       Product product = productFactory.createProduct("1234", "Iphone17", "promax", "R29000");


       Store store = StoreFactory.createStore("410", "Istore", "0114101754", "cape town"
               ,product);
       System.out.println(store.toString());


   }
}

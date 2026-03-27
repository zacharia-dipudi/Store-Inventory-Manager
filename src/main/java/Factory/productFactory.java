/*Author : Zacharia dipidi
Date: 24 march 2026
 */
package Factory;

import Domain.Product;
import Util.Helper;

public class productFactory {
    public static Product createProduct(String productId, String productName, String productDescription, String productPrice){


        if(Helper.isNullOrEmpty(productId)
                || Helper.isNullOrEmpty(productName)
                || Helper.isNullOrEmpty(productDescription)
                || Helper.isNullOrEmpty(productPrice)) {
            return null;
        }
        return new Product.Builder()
                .setProductId(productId)
                .setProductName(productName)
                .setProductDescription(productDescription)
                .setProductPrice(productPrice)
                .build();
    }
}

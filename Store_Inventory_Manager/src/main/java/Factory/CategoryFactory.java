package Factory;

/* CustomerCategory.java
CustomerCategory class
Author: Jayden Avontuur (222032278)
Date: 19 March 2026*/

import Domain.Category;
import Util.Helper;

public class CategoryFactory {

    public static Category createCategory(String categoryId, String name, String description) {
        if(Helper.isNullOrEmpty(categoryId) || Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(description)){
            return null;
        }

        return new Category.Builder(categoryId, name)
                .setDescription(description)
                .build();
    }
}

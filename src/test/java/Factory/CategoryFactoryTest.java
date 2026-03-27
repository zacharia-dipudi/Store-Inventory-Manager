package Factory;

/* CategoryFactoryTest.java
CategoryFactoryTest class
Author: Jayden Avontuur (222032278)
Date: 21 March 2026*/

import org.junit.jupiter.api.Test;
import Domain.Category;

import static org.junit.jupiter.api.Assertions.*;

class CategoryFactoryTest {

    @Test
    void createCategory_success() {

        Category category = CategoryFactory.createCategory(
                "C01",
                "Electronics",
                "Devices and gadgets"
        );

        assertNotNull(category);
        assertEquals("C01", category.getCategoryId());
        assertEquals("Electronics", category.getName());
    }

    @Test
    void createCategory_nullId() {

        Category category = CategoryFactory.createCategory(
                null,
                "Electronics",
                "Devices"
        );

        assertNull(category);
    }

    @Test
    void createCategory_emptyName() {

        Category category = CategoryFactory.createCategory(
                "C01",
                "",
                "Devices"
        );

        assertNull(category);
    }
}

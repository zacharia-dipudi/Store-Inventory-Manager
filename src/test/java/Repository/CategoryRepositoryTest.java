package Repository;

/* CategoryRepositoryTest.java
CategoryRepositoryTest class
Author: Jayden Avontuur (222032278)
Date: 21 March 2026*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Domain.Category;
import Factory.CategoryFactory;

import static org.junit.jupiter.api.Assertions.*;

class CategoryRepositoryTest {

    private ICategoryRepository repository;
    private Category category;

    @BeforeEach
    void setUp() {
        repository = CategoryRepository.getRepository();

        category = CategoryFactory.createCategory(
                "C01",
                "Electronics",
                "Devices"
        );
    }

    @Test
    void create() {
        Category created = repository.create(category);
        assertNotNull(created);
        assertEquals(category.getCategoryId(), created.getCategoryId());
    }

    @Test
    void read() {
        repository.create(category);
        Category read = repository.read("C01");
        assertNotNull(read);
    }

    @Test
    void update() {
        repository.create(category);

        Category updatedCategory = new Category.Builder("C01", "Electronics")
                .setDescription("Updated Description")
                .build();

        Category updated = repository.update(updatedCategory);
        assertNotNull(updated);
        assertEquals("Updated Description", updated.getDescription());
    }

    @Test
    void delete() {
        repository.create(category);
        boolean deleted = repository.delete("C01");
        assertTrue(deleted);
    }

    @Test
    void getAll() {
        repository.create(category);
        assertFalse(repository.getAll().isEmpty());
    }
}
package Repository;

/* CategoryRepository.java
CategoryRepositoryImpl class
Author: Jayden Avontuur (222032278)
Date: 21 March 2026*/

import Domain.Category;

import java.util.HashSet;
import java.util.Set;

public class CategoryRepository implements ICategoryRepository {

    private static CategoryRepository repository = null;
    private Set<Category> categoryDB;

    private CategoryRepository() {
        categoryDB = new HashSet<>();
    }

    public static CategoryRepository getRepository() {
        if (repository == null) {
            repository = new CategoryRepository();
        }
        return repository;
    }

    @Override
    public Category create(Category category) {
        categoryDB.add(category);
        return category;
    }

    @Override
    public Category read(String categoryId) {
        for (Category c : categoryDB) {
            if (c.getCategoryId().equals(categoryId)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public Category update(Category category) {
        Category oldCategory = read(category.getCategoryId());
        if (oldCategory != null) {
            categoryDB.remove(oldCategory);
            categoryDB.add(category);
            return category;
        }
        return null;
    }

    @Override
    public boolean delete(String categoryId) {
        Category category = read(categoryId);
        if (category != null) {
            categoryDB.remove(category);
            return true;
        }
        return false;
    }

    @Override
    public Set<Category> getAll() {
        return categoryDB;
    }
}
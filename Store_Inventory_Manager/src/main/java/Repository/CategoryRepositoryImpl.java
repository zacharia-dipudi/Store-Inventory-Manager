package Repository;

import Domain.Category;

import java.util.HashSet;
import java.util.Set;

public class CategoryRepositoryImpl implements CategoryRepository {

    private static CategoryRepositoryImpl repository = null;
    private Set<Category> categoryDB;

    private CategoryRepositoryImpl() {
        categoryDB = new HashSet<>();
    }

    public static CategoryRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new CategoryRepositoryImpl();
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
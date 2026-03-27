package Domain;

/* Category.java
Category class
Author: Jayden Avontuur (222032278)
Date: 19 March 2026*/

public class Category {

    private final String categoryId;
    private final String name;
    private final String description;

    private Category(Builder builder) {
        this.categoryId = builder.categoryId;
        this.name = builder.name;
        this.description = builder.description;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static class Builder {

        private String categoryId;
        private String name;
        private String description;

        public Builder(String categoryId, String name) {
            this.categoryId = categoryId;
            this.name = name;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Category build() {
            return new Category(this);
        }
    }
}
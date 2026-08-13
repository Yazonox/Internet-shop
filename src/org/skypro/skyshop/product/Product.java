package org.skypro.skyshop.product;

public abstract class Product implements Searchable {

    private final String name;


    public Product(String productName) {
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Невеврное наименование продукта");
        } else {
            this.name = productName;
        }
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    @Override
    public String toString() {
        return name;
    }

    public abstract boolean isSpecial();


    //3
    @Override
    public String getSearchTerm() {
        return getName();
    }
    //3
    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    //3  ????
    @Override
    public String getObjectName() {
        return this.name;
    }

    @Override
    public String getStringRepresentation() {
        return Searchable.super.getStringRepresentation();
    }

}

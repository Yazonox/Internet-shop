package org.skypro.skyshop.product;

import java.util.Objects;

public abstract class Product implements Searchable,Comparable<Product> {

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

    @Override
    public int hashCode() {
        return Objects.hashCode(name);//Map переопределить
    }

    @Override
    public boolean equals(Object obj) {//Map переопределить
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Product product = (Product) obj;

        return Objects.equals(name, product.name);
    }

    @Override
    public int compareTo(Product o) {
        return this.getName().compareTo(o.getName());
    }
}

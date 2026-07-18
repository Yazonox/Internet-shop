package org.skypro.skyshop.product;

public class Product {

    private final String name;
    private final int price;

    public Product(String productName, int price) {
        this.name = productName;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + ": " + price;
    }
}

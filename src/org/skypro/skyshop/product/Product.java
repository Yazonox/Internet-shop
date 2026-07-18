package org.skypro.skyshop.product;

public abstract class Product {

    private final String name;


    public Product(String productName) {
        this.name = productName;
        //this.price = price;
    }


    public String getName() {
        return name;
    }

    public abstract int getPrice();

    @Override
    public String toString() {
        return name; //+ ": " + price;
    }

    public abstract boolean isSpecial();
}

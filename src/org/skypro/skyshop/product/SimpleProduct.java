package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String productName, int price) {
        super(productName);
        if (price > 0) {
            this.price = price;
        } else {
            throw  new IllegalArgumentException("Неверно введена цена продукта");
        }

    }

    @Override
    public int getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return super.getName() + ": " + this.price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}

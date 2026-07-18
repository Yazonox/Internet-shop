package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private int basePrice;
    private int discount;
    private static final int KOEFF = 100;

    public DiscountedProduct(String productName, int basePrice, int discountWholePercent) {
        super(productName);
        this.basePrice = basePrice;
        this.discount = discountWholePercent;
    }

    @Override
    public int getPrice() {
        return this.basePrice - (basePrice * discount / KOEFF);
    }

    @Override
    public String toString() {
        return super.getName() + ": " + this.getPrice() + " (" + discount + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}

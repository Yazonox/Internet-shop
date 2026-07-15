package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private static Product[] products = new Product[5];


    public void addProduct(Product prod) {
        int check = 0;
        for (int i = 0; i <= products.length - 1; i++) {
            if (products[i] == null) {
                check = 1;
                products[i] = prod;
                System.out.println(products[i]);
                break;
            }
        }
        if (check == 0) {
            System.out.println("Невозможно добавить продукт: " + prod);
        }
    }

    public int gettingTotalCost() {
        int cost = 0;
        for (Product product : products) {
            if (product != null) {
                cost += product.getPrice();
            }
        }
        if (cost == 0) {
            System.out.println("Корзина пуста");
            return 0;
        }
        return cost;
    }

    public void printBasket() {
        int check = 0;
        for (Product product : products) {
            if (product != null) {
                check = 1;
                System.out.println(product);
            }
        }
        if (check == 0) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Итого: " + gettingTotalCost());
        }
    }

    public Boolean findProduct(String name) {
        for (Product product : products) {

            if (product != null && product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i <= products.length - 1; i++) {
            products[i] = null;
        }
    }


}

package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {


    private List<Product> products = new LinkedList<>();


    //Дообавление продукта в корзину
    public void addProduct(Product prod) {
        if (prod != null) {
            products.add(prod);
        } else {
            System.out.println("Товар не добавлен");
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

    //Вывод продуктов в корзине на экран
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
            System.out.println("Количество специальных товаров: " + gettingSumSpecial());

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


    //Очистка корзины
    public void clearBasket() {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product element = iterator.next();
            iterator.remove();
        }
    }


    public int gettingSumSpecial() {
        int sumSpec = 0;
        for (Product product : products) {
            if (product != null && product.isSpecial()) {
                sumSpec++;
            }
        }
        return sumSpec;
    }

    //Удаление продукта из корзины по имени
    public List<Product> removeByName(String delName) {

        List<Product> delSearch = new LinkedList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product element = iterator.next();
            if ((element.getName()).equals(delName)) {
                delSearch.add(element);
                iterator.remove();
            }

        }
        if (delSearch.isEmpty()) {
            System.out.println("Список пуст");
        }
        return delSearch;
    }


}

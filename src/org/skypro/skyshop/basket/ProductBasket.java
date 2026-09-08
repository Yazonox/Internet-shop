package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {


    private Map<String, List<Product>> products = new HashMap<>();


    //Дообавление продукта в корзину
    public void addProduct(Product prod) {
        if (prod != null) {
            products.computeIfAbsent(prod.getName(), K -> new ArrayList<>()).add(prod);
            System.out.println("Товар добавлен: " + prod.getName());
        } else {
            System.out.println("Товар не добавлен");
        }
    }


    //Подсчет стоимости корзины
    public int gettingTotalCost() {
        int cost = 0;
        if (products.isEmpty()) {

            System.out.println("Корзина пуста");
            return 0;

        } else {


            cost = products.values().stream().flatMap(Collection::stream)
                    .mapToInt(Product::getPrice)
                    .sum();

        }
        return cost;
    }






    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {

            products.values().stream().flatMap(Collection::stream).forEach(System.out::println);

            System.out.println("Количество специальных товаров: " + getSpecialCount());
        }
    }



    //Проверка наличия продукта в корзине
    public Boolean findProduct(String name) {
        return products.containsKey(name);
    }


    //Очистка корзины
    public void clearBasket() {
        products.clear();
    }



    private int getSpecialCount() {

        long sumSpec = products.values().stream().flatMap(Collection::stream)
                .filter(prodL -> prodL != null && prodL.isSpecial())
                        .count();
        return (int)sumSpec;
    }


    //Удаление продукта из корзины по имени
    public List<Product> removeByName(String delName) {

        List<Product> delSearch = new LinkedList<>();

        for (Map.Entry<String, List<Product>> prodM : products.entrySet()) {
            List<Product> productsL = prodM.getValue();
            Iterator<Product> iterator = productsL.iterator();

            while (iterator.hasNext()) {
                Product element = iterator.next();
                if ((element.getName()).equals(delName)) {
                    delSearch.add(element);
                    iterator.remove();
                }

            }

        }
        if (delSearch.isEmpty()) {
            System.out.println("Список пуст");
        }
        return delSearch;
    }


}

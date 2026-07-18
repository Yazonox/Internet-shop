package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {

    public static void main(String[] args) {

        System.out.println("Интернет магазин");

        System.out.println("Создание продуктов");
        Product carrot = new Product("морковь", 50);
        Product rice = new Product("рис", 60);
        Product bread = new Product("хлеб", 45);
        Product onion = new Product("лук", 40);
        Product sugar = new Product("сахар", 70);
        Product potato = new Product("картофель", 65);


        ProductBasket prBasket = new ProductBasket();


        System.out.println("Добавление продукта в корзину");
        prBasket.addProduct(carrot);
        prBasket.addProduct(rice);
        prBasket.addProduct(bread);
        prBasket.addProduct(onion);
        prBasket.addProduct(sugar);


        System.out.println("Добавление продукта в заполненную корзину, в которой нет свободного места");
        prBasket.addProduct(potato);


        System.out.println("Печать содержимого корзины с несколькими товарами");
        prBasket.printBasket();

        System.out.println("Получение стоимости корзины с несколькими товарами");
        System.out.println(prBasket.gettingTotalCost());

        System.out.println("Поиск товара, который есть в корзине");
        System.out.println(prBasket.findProduct("рис"));

        System.out.println("Поиск товара, которого нет в корзине");
        System.out.println(prBasket.findProduct("картофель"));

        System.out.println("Очистка корзины");
        prBasket.clearBasket();


        System.out.println("Печать содержимого пустой корзины");
        prBasket.printBasket();

        System.out.println("Получение стоимости пустой корзины");
        System.out.println(prBasket.gettingTotalCost());

        System.out.println("Поиск товара по имени в пустой корзине");
        System.out.println(prBasket.findProduct("сахар"));


    }

}

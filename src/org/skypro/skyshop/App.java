package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

import java.util.Arrays;


public class App {

    public static void main(String[] args) {

        System.out.println("Интернет магазин");

        System.out.println("Создание продуктов");
        DiscountedProduct carrot = new DiscountedProduct("морковь", 50, 10);
        FixPriceProduct rice = new FixPriceProduct("рис");
        SimpleProduct bread = new SimpleProduct("хлеб", 45);
        SimpleProduct onion = new SimpleProduct("лук", 40);
        DiscountedProduct sugar = new DiscountedProduct("сахар", 70, 20);
        SimpleProduct potato = new SimpleProduct("картофель", 65);


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

        
        System.out.println("Создание объекта типа SearchEngine");
        SearchEngine searchOne = new SearchEngine(10);


        Searchable breadS = new Article("хлеб","История хлеба началась задолго до письменности");
        Searchable riceS = new Article("рис", "Одно из древнейших и важнейших зерновых растений");
        Searchable sugarS = new Article("сахар", "Пищевой продукт со сладким вкусом");
        Searchable carrotS = new Article("морковь", "Широко распространённая овощная культура");


        searchOne.clearSearhable();


        searchOne.add(breadS);
        searchOne.add(riceS);
        searchOne.add(sugarS);
        searchOne.add(carrotS);
        searchOne.add(bread);
        searchOne.add(rice);
        searchOne.add(sugar);
        searchOne.add(carrot);
        searchOne.add(onion);
        searchOne.add(potato);

        //System.out.println(searchOne);
        System.out.println(Arrays.toString(searchOne.search(rice.getSearchTerm())));


    }

}

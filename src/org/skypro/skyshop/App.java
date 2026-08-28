package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

import java.io.DataInputStream;
import java.util.Arrays;
import java.util.List;


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
        DiscountedProduct potato2 = new DiscountedProduct("картофель", 65, 20);


        ProductBasket prBasket = new ProductBasket();


        System.out.println("Добавление продукта в корзину");
        prBasket.addProduct(carrot);
        prBasket.addProduct(rice);
        prBasket.addProduct(bread);
        prBasket.addProduct(onion);
        prBasket.addProduct(sugar);
        prBasket.addProduct(potato);




        System.out.println("Печать содержимого корзины с несколькими товарами");
        prBasket.printBasket();

        System.out.println("Получение стоимости корзины с несколькими товарами");
        System.out.println(prBasket.gettingTotalCost());

        System.out.println("Поиск товара, который есть в корзине");
        System.out.println(prBasket.findProduct("рис"));

        System.out.println("Поиск товара, которого нет в корзине");
        System.out.println(prBasket.findProduct("абрикос"));

        System.out.println("Очистка корзины");
        prBasket.clearBasket();


        System.out.println("Печать содержимого пустой корзины");
        prBasket.printBasket();

        System.out.println("Получение стоимости пустой корзины");
        System.out.println(prBasket.gettingTotalCost());

        System.out.println("Поиск товара по имени в пустой корзине");
        System.out.println(prBasket.findProduct("сахар"));

        
        System.out.println("Создание объекта типа SearchEngine");
        SearchEngine searchOne = new SearchEngine();


        Searchable breadS = new Article("хлеб","История хлеба началась задолго до письменности");
        Searchable riceS = new Article("рис", "В китайской культуре рис часто сравнивают с хлебом ");
        Searchable sugarS = new Article("сахар", "Пищевой продукт со сладким вкусом");
        Searchable carrotS = new Article("морковь", "Широко распространённая овощная культура");
        Searchable potatoS = new Article("картофель", "По пищевой ценности картофель  близок к хлебу");
        Searchable beanS = new Article("фасоль", "Как источник растительного белка фасоль сравнивают с хлебом");




        searchOne.clearSearchable();


        searchOne.add(breadS);
        searchOne.add(riceS);
        searchOne.add(sugarS);
        searchOne.add(carrotS);
        searchOne.add(potatoS);
        searchOne.add(beanS);
        searchOne.add(bread);
        searchOne.add(rice);
        searchOne.add(sugar);
        searchOne.add(carrot);
        searchOne.add(onion);
        searchOne.add(potato);


        //System.out.println(searchOne);
        System.out.println();
        System.out.println();
        System.out.println("Поисковый запрос:");
        System.out.println();

        //System.out.println(searchOne.search("хлеб"));
        searchOne.printSearch(searchOne.search("хлеб"));
        System.out.println();
        System.out.println();

        System.out.println("Проверка исключений");


        try {
            SimpleProduct salt = new SimpleProduct(null, 25);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            SimpleProduct pears = new SimpleProduct("груши", -120);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            DiscountedProduct plum = new DiscountedProduct("слива", -80, 20);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            DiscountedProduct tomato = new DiscountedProduct("помидор", 30, -60);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Запрос, когда нужный объект существует");

        String searchIt = "хлеб";
        try {
            Searchable searchProd = searchOne.searchBestResult(searchIt);
            System.out.println(searchProd);
        } catch (BestResultNotFound e) {
            System.out.println("По запросу: <<" + searchIt + ">> ничего не найдено.");
        }

        System.out.println("Запрос, выбрасывающий исключение");

        String searchIt1 = "помидор";
        try {
            Searchable searchProd = searchOne.searchBestResult(searchIt1);
            System.out.println(searchProd);
        } catch (BestResultNotFound e) {
            System.out.println("По запросу: <<" + searchIt1 + ">> ничего не найдено.");
        }


        System.out.println();
        System.out.println();
        System.out.println("Удаление продукта по имени из корзины");
        //_______________________________
        prBasket.addProduct(carrot);
        prBasket.addProduct(rice);
        prBasket.addProduct(bread);
        prBasket.addProduct(bread);
        prBasket.addProduct(onion);
        prBasket.addProduct(sugar);
        prBasket.addProduct(potato);
        prBasket.addProduct(potato2);


        prBasket.printBasket();

        System.out.println();
        System.out.println("1. Удалить существующий продукт из корзины");
        List<Product> printBasket = prBasket.removeByName("хлеб");

        System.out.println();
        System.out.println("2. Вывести удаленные продукты на экран");
        System.out.println(printBasket.toString());

        System.out.println();
        System.out.println("3. Вывести содержимое корзины с помощью метода printBasket");
        prBasket.printBasket();

        System.out.println();
        System.out.println("4. Удалить несуществующий продукт");
        System.out.println("5. Проверить, что список удаленных продуктов пустой и вывести сообщение “Список пуст”.");
        prBasket.removeByName("апельсин");

        System.out.println();
        System.out.println("6. Вывести содержимое корзины на экран.");
        prBasket.printBasket();

        prBasket.clearBasket();




    }

}

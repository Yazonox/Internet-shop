package org.skypro.skyshop.product;

import java.util.*;

public class SearchEngine {
    private List<Searchable> searchables;


    //Конструктор
    public SearchEngine() {
        this.searchables = new LinkedList<>();
    }


    //принимает в себя строку для поиска и возвращает 5 результатов поиска по массиву
    //Searchable в виде массива из 5 элементов.
    public List<Searchable> search(String searchTerm) {

        List<Searchable> rezultSearch = new LinkedList<>();
        for (Searchable searchable : searchables) {
            if (searchable != null && (searchable.getSearchTerm()).contains(searchTerm)) {
                rezultSearch.add(searchable);


            }
        }
        return rezultSearch;
    }

    //добавляет новый объект типа Searchable в массив поискового движка.
    public void add(Searchable obj) {
        if (obj != null) {
            searchables.add(obj);
        } else {
            System.out.println("Объект не добавлен");
        }
    }


    public void clearSearchable() {
        Iterator<Searchable> iterator = searchables.iterator();
        while (iterator.hasNext()) {
            Searchable element = iterator.next();
            iterator.remove();
        }
    }

    @Override
    public String toString() {
        return searchables.toString();
    }


    // Метод получения количества повторений подстроки
    public int getNumberSubstrings(Searchable obj, String searchT) {
        String str = obj.getSearchTerm();
        String substring = searchT;
        int number = 0;
        int ind = 0;
        int indSubstr = str.indexOf(substring, ind);

        while (indSubstr != -1) {
            number++;
            ind = indSubstr + substring.length();
            indSubstr = str.indexOf(substring, ind);
        }
        return number;

    }


    // Метод поиска самого подходящего элемента
    public Searchable searchBestResult(String searchTerm) throws BestResultNotFound {
        Searchable bestResObj = null;
        int bestNumberS = 0;
        for (Searchable searchable : searchables) {
            int numberS = getNumberSubstrings(searchable, searchTerm);
            if (bestNumberS < numberS) {
                bestNumberS = numberS;
                bestResObj = searchable;
            }
        }

        if (bestResObj != null) {
            return bestResObj;
        } else {
            throw new BestResultNotFound("Совпадения не найдены");
        }
    }
}

package org.skypro.skyshop.product;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private Set<Searchable> searchables;


    //Конструктор
    public SearchEngine() {
        this.searchables = new HashSet<>();
    }


    //принимает в себя строку  и возвращает  результаты поиска по массиву
    //searchable .
    public Set<Searchable> search(String searchTerm) {


        Set<Searchable> rezultSearch = searchables.stream()
                .filter(searchable -> searchable != null && (searchable.getSearchTerm()).contains(searchTerm) )
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchEngineComparator())));


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

    //Очистка поискового массива
    public void clearSearchable() {
        searchables.clear();
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
    //Печать результата поиска (search())

    public void printSearch(Set<Searchable> search) {
        for (Searchable element : search) {
            System.out.println(element);
        }
    }


    //Компаратор
    public static class SearchEngineComparator implements Comparator<Searchable> {

        public int compare(Searchable s1, Searchable s2) {
            int rezCompare = Integer.compare((s2.getObjectName()).length(), (s1.getObjectName()).length());
            if (rezCompare == 0) {
                return s1.getObjectName().compareTo(s2.getObjectName());
            } else {
                return rezCompare;
            }
        }
    }


}

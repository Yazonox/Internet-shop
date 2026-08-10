package org.skypro.skyshop.product;

import java.util.Arrays;

public class SearchEngine {
    private Searchable[] searchables;

    public SearchEngine( int i) {         //Searchable[] searchables
        this.searchables = new Searchable[i];
    }



    //принимает в себя строку для поиска и возвращает 5 результатов поиска по массиву
    //Searchable в виде массива из 5 элементов.
    public Searchable[] search(String searchTerm) {
            int i = 0;
        Searchable[] rezultSearch = new Searchable[5];
        for (Searchable searchable : searchables) {
            if (searchable != null && (searchable.getSearchTerm()).contains(searchTerm)) {
                rezultSearch[i] = searchable;
                //System.out.println("Добавлен в Search");
                if (i == 4) {
                    System.out.println("Свободные ячейки закончились");
                    break;
                } else {
                    i++;
                }
            }
        }
        return rezultSearch;
    }

    //добавляет новый объект типа Searchable в массив поискового движка.
    public  void add(Searchable obj) {
        int check = 0;
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                searchables[i] = obj;
                check = 1;
                //System.out.println("Добавлен");
                break;
            }
        }
        if (check == 0) {
            System.out.println("Не удалось добавить объект. Массив заполнен.");
        }
    }

    public void clearSearchable() {
        for (int i = 0; i < searchables.length; i++) {
            searchables[i] = null;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(searchables);
    }



    // Метод получения количества повторений подстроки
    public int getNumberSubstrings(Searchable obj, String searchT) {
           String  str = obj.getSearchTerm();
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
           int numberS = getNumberSubstrings(searchable,searchTerm);
            if (bestNumberS < numberS) {
                bestNumberS++;
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

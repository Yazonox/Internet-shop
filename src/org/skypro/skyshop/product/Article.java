package org.skypro.skyshop.product;

import java.util.Objects;

public class Article implements Searchable, Comparable<Article> {
    private final String artName;
    private final String artText;

    public Article(String artName, String artText) {
        this.artName = artName;
        this.artText = artText;
    }

    public String getArtName() {
        return artName;
    }

    public String getArtText() {
        return artText;
    }


    //3
    @Override
    public String toString() {
        return artName + "\n" + artText;
    }
    //3
    @Override
    public String getSearchTerm() {
        return artName + "\n" + artText ;
    }
    //3
    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    //3   ????
    @Override
    public String getObjectName() {
        return this.artName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if  (!(o instanceof Article article)) return false;
        return Objects.equals(artName, article.artName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(artName);
    }

    @Override
    public int compareTo(Article o) {
        return this.getArtName().compareTo(o.getArtName());
    }
}


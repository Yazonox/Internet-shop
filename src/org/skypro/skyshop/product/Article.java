package org.skypro.skyshop.product;

public class Article implements Searchable {
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
}


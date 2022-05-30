package com.example.lab5.books.classes;

public abstract class Book {

    final String name;
    String type;
    String lang;


    protected Book(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getLang() {
        return lang;
    }
}

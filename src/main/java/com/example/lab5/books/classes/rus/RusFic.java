package com.example.lab5.books.classes.rus;

public class RusFic extends Rus{

    String author;

    public RusFic(String name, String author) {
        super(name);
        this.author = author;
        setType("Художественные");
    }

    public String getAuthor() {
        return author;
    }
}

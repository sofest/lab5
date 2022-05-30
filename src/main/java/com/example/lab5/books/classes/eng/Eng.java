package com.example.lab5.books.classes.eng;

import com.example.lab5.books.classes.Book;

public abstract class Eng extends Book {


    final String author;

    public String getAuthor() {
        return author;
    }

    public Eng(String name, String author) {
        super(name);
        this.author = author;
        setLang("EN");
    }


}

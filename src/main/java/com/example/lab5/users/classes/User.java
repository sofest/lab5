package com.example.lab5.users.classes;

import com.example.lab5.books.classes.Book;

import java.util.HashSet;

public abstract class User {

    final String name;
    final String surname;
    HashSet<Book> books = new HashSet<>();

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public HashSet getBooks() {
        return books;
    }

    public void setBooks(HashSet books) {
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFullName() {
        return name + " " + surname;
    }
}

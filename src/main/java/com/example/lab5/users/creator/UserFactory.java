package com.example.lab5.users.creator;

import com.example.lab5.books.classes.Book;
import com.example.lab5.users.classes.Professor;
import com.example.lab5.users.classes.Student;
import com.example.lab5.users.classes.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class UserFactory {

    CreateArr createU;
    ArrayList<User> users = new ArrayList<User>();
    public UserFactory(CreateArr createU) {
        this.createU = createU;
    }
    public ArrayList<User> createProf(ArrayList<Book> booksList) {
        User user;
        int profs = ThreadLocalRandom.current().nextInt(5, 15);
        int profW = ThreadLocalRandom.current().nextInt(0, profs);
        for (int i = 0; i < profs - profW; i++) {
            user = createProfessor(i);
            user.setBooks(genBooks(booksList));
            users.add(user);
        }
        for (int i = profs - profW; i < profs; i++) {
            user = createWProfessor(i);
            user.setBooks(genBooks(booksList));
            users.add(user);
        }
        int student = ThreadLocalRandom.current().nextInt(20, 32);
        int studentW = ThreadLocalRandom.current().nextInt(0, student);
        for (int i = 0; i < student - studentW; i++) {
            user = createStudent(i);
            user.setBooks(genBooks(booksList));
            users.add(user);
        }
        for (int i = student - studentW; i < student; i++){
            user = createWStudent(i);
            user.setBooks(genBooks(booksList));
            users.add(user);
        }
        return users;
    }

    public Student createStudent(int i) {
//        return new Student(imp.randomU(imp.getArrMNames()), imp.randomU(imp.getArrMSurnames()));
        return new Student(createU.getArrMNames()[i], createU.getArrMSurnames()[i]);
    }

    public Student createWStudent(int i) {
        return new Student(createU.getArrWNames()[i], createU.randomWSurname(createU.getArrMSurnames()[i]));
    }

    public Professor createProfessor(int i) {
        return new Professor(createU.getArrMNames()[i], createU.getArrMMiddle()[i], createU.getArrProfSurnames()[i]);
    }

    public Professor createWProfessor(int i) {
        return new Professor(createU.getArrWNames()[i], createU.getArrWMiddle()[i], createU.randomWSurname(createU.getArrProfSurnames()[i]));
    }
    public HashSet genBooks(ArrayList<Book> booksList) {
        int num = ThreadLocalRandom.current().nextInt(3, 11);
        HashSet<Book> books = new HashSet<>();
        for (int i = 0; i < num; i++) {
            books.add(booksList.get(ThreadLocalRandom.current().nextInt(0, booksList.size())));
        }
        return books;
    }
}

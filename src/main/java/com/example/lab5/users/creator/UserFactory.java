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
    ArrayList<User> users = new ArrayList<>();
    public UserFactory(CreateArr createU) {
        this.createU = createU;
    }
        public User createUser(ArrayList<Book> booksList) {
            User user;
            int countUsers = ThreadLocalRandom.current().nextInt(1,4);
            switch(countUsers) {
                case(1): user = createWProfessor(); break;
                case(2): user = createProfessor(); break;
                case(3): user = createWStudent(); break;
                case(4): user = createStudent(); break;
                default:
                    throw new IllegalStateException("Unexpected value: " + countUsers);
            }
            user.setBooks(genBooks(booksList));
            return user;
            }

    public Student createStudent() {
        return new Student(createU.randomU(createU.getArrMNames()), createU.randomU(createU.getArrMSurnames()));
    }

    public Student createWStudent() {
        return new Student(createU.randomU(createU.getArrWNames()), createU.createWSurname(createU.randomU(createU.getArrMSurnames())));
    }

    public Professor createProfessor() {
        return new Professor(createU.randomU(createU.getArrMNames()), createU.randomU(createU.getArrMMiddle()), createU.randomU(createU.getArrProfSurnames()));
    }

    public Professor createWProfessor() {
        return new Professor(createU.randomU(createU.getArrWNames()), createU.randomU(createU.getArrWMiddle()), createU.createWSurname(createU.randomU(createU.getArrProfSurnames())));
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

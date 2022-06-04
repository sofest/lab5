package com.example.lab5.books.creator;

import com.example.lab5.books.classes.Book;
import com.example.lab5.books.classes.eng.EngEd;
import com.example.lab5.books.classes.eng.EngFic;
import com.example.lab5.books.classes.rus.RusEd;
import com.example.lab5.books.classes.rus.RusFic;

import java.util.concurrent.ThreadLocalRandom;

public class BookFactory {

    CreateB createB;

    public BookFactory(CreateB createB) {
        this.createB = createB;
    }

    public Book createBook() {
        Book book;
        int countBook = ThreadLocalRandom.current().nextInt(0, 4);
        switch (countBook){
            case(0): book = createEngEd(); break;
            case(1): book = createEngFic(); break;
            case(2): book = createRusEd(); break;
            case(3): book = createRusFic(); break;
            default:
                throw new IllegalStateException("Unexpected value: " + countBook);
        }
        return book;
    }

    public EngEd createEngEd() {
        return new EngEd(createB.randomB(createB.getArrEnEdNames()), createB.randomB(createB.getArrEnEdAuthors()), createB.randomB(createB.getArrEnEdUniversities()));
    }

    public EngFic createEngFic() {
        return new EngFic(createB.randomB(createB.getArrEnFicNames()), createB.randomB(createB.getArrEnFicAuthors()));
    }

    public RusEd createRusEd() {
        return new RusEd(createB.randomRusB(createB.getArrRuEdNames()));
    }

    public RusFic createRusFic() {
        return new RusFic(createB.randomB(createB.getArrRuFicNames()), createB.randomB(createB.getArrRuFicAuthors()));
    }

}

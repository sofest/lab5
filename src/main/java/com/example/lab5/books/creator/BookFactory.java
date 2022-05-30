package com.example.lab5.books.creator;

import com.example.lab5.books.classes.Book;
import com.example.lab5.books.classes.eng.EngEd;
import com.example.lab5.books.classes.eng.EngFic;
import com.example.lab5.books.classes.rus.RusEd;
import com.example.lab5.books.classes.rus.RusFic;

import java.util.concurrent.ThreadLocalRandom;

public class BookFactory {

    CreateB imp;

    public BookFactory(CreateB imp) {
        this.imp = imp;
    }

    public Book createBook() {
        Book book;
        int rand = ThreadLocalRandom.current().nextInt(0, 100);
        if (rand < 25) {
            book = createEngEd();
        } else if (rand < 50) {
            book = createEngFic();
        } else if (rand < 75) {
            book = createRusEd();
        } else {
            book = createRusFic();
        }
        return book;
    }

    public EngEd createEngEd() {
        return new EngEd(imp.randomB(imp.getArrEnEdNames()), imp.randomB(imp.getArrEnEdAuthors()), imp.randomB(imp.getArrEnEdUniversities()));
    }
    public String ficEngBuilder(){
        StringBuilder builder = new StringBuilder();
        builder.append(imp.randomB(imp.getArrEnFicNames())).append(imp.randomB(imp.getArrEnFicAuthors()));
        return builder.toString();
    }

    public EngFic createEngFic() {
        return new EngFic(imp.randomB(imp.getArrEnFicNames()), imp.randomB(imp.getArrEnFicAuthors()));
    }

    public RusEd createRusEd() {
        return new RusEd(imp.randomRusB(imp.getArrRuEdNames()));
    }

    public RusFic createRusFic() {
        return new RusFic(imp.randomB(imp.getArrRuFicNames()), imp.randomB(imp.getArrRuFicAuthors()));
    }

}

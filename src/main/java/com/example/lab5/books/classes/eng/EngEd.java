package com.example.lab5.books.classes.eng;

import java.util.concurrent.ThreadLocalRandom;

public class EngEd extends Eng {

    String lvl;
    String university;

    public EngEd(String name, String author, String university) {
        super(name, author);
        this.university = university;
        setType("Educational");
        setLvl();
    }

    public String getLvl() {
        return lvl;
    }

    public String getUniversity() {
        return university;
    }

    public void setLvl() {
        if (ThreadLocalRandom.current().nextInt(0, 100)<50){
            this.lvl = "Master";
        } else {
            this.lvl = "Bachelor";
        }
    }
}

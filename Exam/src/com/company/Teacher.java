package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Teacher extends Person {

    public Teacher() {
    }

    public Teacher(String name, Date birthday) {
        super(name, birthday);
    }

    @Override
    public String toString() {
        String base = super.toString();

        StringBuilder stringBuilder = new StringBuilder();


        return base + stringBuilder.toString();
    }
}

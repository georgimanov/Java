package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Student extends Person {

    public Student() {
    }

    public Student(String name, Date birthday) {
        super(name, birthday);
    }

    @Override
    public String toString() {
        String base = super.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(base);


        return stringBuilder.toString();
    }
}

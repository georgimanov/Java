package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.Comparator;

public class Person implements IPerson{
    private String name = Constants.EMPTY_STRING;
    private Date birthday = new Date();

    public Person(){
        this("", new Date());
    }

    public Person(String name, Date birthday){
        SetName(name);
        SetBirthday(birthday);
    }

    public String GetName(){
        return this.name;
    }

    void SetName(String name){
        this.name = name;
    }

    public Date GetBirthday(){
        return this.birthday;
    }

    void SetBirthday(Date birthday){
        this.birthday = birthday;
    }

    // http://beginnersbook.com/2013/12/java-arraylist-of-object-sort-example-comparable-and-comparator/
    /*Comparator for sorting the list by Student Name*/
    public static Comparator<Person> PersonNameComparator = new Comparator<Person>() {

        public int compare(Person p1, Person p2) {
            String personName1 = p1.GetName().toUpperCase();
            String personName2 = p2.GetName().toUpperCase();

            //ascending order
            return personName1.compareTo(personName2);

            //descending order
            //return personName2.compareTo(personName1);
        }};

    /*Comparator for sorting the list by age */
    public static Comparator<Person> PersonAgeComparator = new Comparator<Person>() {

        public int compare(Person p1, Person p2) {

            Date birthday1 = p1.GetBirthday();
            Date birthday2 = p2.GetBirthday();

	   /*For ascending order*/
            // return birthday1.compareTo(birthday2);

	   /*For descending order*/
            return birthday2.compareTo(birthday1);
        }};


    @Override
    public String toString() {
        String role = this.getClass().getName();
        String roleResult = role.substring(role.length() - 7);

        return String.format("%s|%s|%s", roleResult, GetName(), GetBirthday());
    }
}
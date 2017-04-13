package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Comparator;

public class Person implements IPerson {
    private String name = Constants.EMPTY_STRING;
    private Date birthday = new Date();
    private String role;
    public Person(){
        this("", new Date());
    }

    public Person(String name, Date birthday){
        setName(name);
        setBirthday(birthday);
    }

    public Person(String name, String role){
        setName(name);
        setRole(role);
    }

    public String getName(){
        return this.name;
    }

    void setName(String name){
        this.name = name;
    }

    public Date getBirthday(){

        return this.birthday;
    }

    public String getBirthdayString(){
        SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT);
        return format.format(this.birthday);
    }

    void setBirthday(Date birthday){
        this.birthday = birthday;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // http://beginnersbook.com/2013/12/java-arraylist-of-object-sort-example-comparable-and-comparator/
    /*Comparator for sorting the list by Student Name*/
    public static Comparator<Person> PersonNameComparator = new Comparator<Person>() {

        public int compare(Person p1, Person p2) {
            String personName1 = p1.getName().toUpperCase();
            String personName2 = p2.getName().toUpperCase();

            //ascending order
            return personName1.compareTo(personName2);

            //descending order
            //return personName2.compareTo(personName1);
        }};

    /*Comparator for sorting the list by age */
    public static Comparator<Person> PersonAgeComparator = new Comparator<Person>() {

        public int compare(Person p1, Person p2) {

            Date birthday1 = p1.getBirthday();
            Date birthday2 = p2.getBirthday();

	   /*For ascending order*/
            // return birthday1.compareTo(birthday2);

	   /*For descending order*/
            return birthday2.compareTo(birthday1);
        }};


    @Override
    public String toString() {
        return String.format("%s|%s", getRole(), getName());
    }
}
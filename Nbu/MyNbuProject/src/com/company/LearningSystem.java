package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class LearningSystem {
    ArrayList<Person> people = new ArrayList<Person>();


    public void addPerson(Person person){
        this.people.add(person);
    }

    public ArrayList<Person> getPeople(){
        return new ArrayList<Person>(this.people);
    }

    public ArrayList<String> getPeopleAsString(){
        ArrayList<String> peopleList = new ArrayList<String>();
        for(IPerson person: this.people){
            String personLine = getPersonAsString(person);
            peopleList.add(personLine);
        }
        return peopleList;
    }

    public void printPeopleSortedAlphabetically(){
        Collections.sort(this.people, Person.PersonNameComparator);

        System.out.println(this + " - People sorted by name");
        for(Person str: this.people){
            System.out.println(str);
        }
    }

    public void printPeopleSortedByAge(){
        Collections.sort(this.people, Person.PersonAgeComparator);

        System.out.println(this + " - People sorted by age");
        for(Person str: this.people){
            System.out.println(str);
        }
    }

    private String getPersonAsString(IPerson person){
        String role = person.getClass().getName();
        String roleResult = role.substring(role.length() - 7);

        return String.format("%s|%s|%s", roleResult, person.getName(), person.getBirthdayString());
    }
}

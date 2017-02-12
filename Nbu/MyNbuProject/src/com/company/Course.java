package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Course {
    private String name = Constants.EMPTY_STRING;
    private ArrayList<Person> people = new ArrayList<Person>();
    private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    private ArrayList<Student> students = new ArrayList<Student>();

    public Course(String name){
        this.name = name;
    }

    void AddStudent(Student student){
        this.people.add(student);
        this.students.add(student);
    }

    void AddTeacher(Teacher teacher){
        this.people.add(teacher);
        this.teachers.add(teacher);
    }

    void PrintPeopleSortedAlphabetically(){
        Collections.sort(this.people, Person.PersonNameComparator);

        System.out.println(this + " - People sorted by name");
        for(Person str: this.people){
            System.out.println(str);
        }
    }

    void PrintPeopleSortedByAge(){
        Collections.sort(this.people, Person.PersonAgeComparator);

        System.out.println(this + " - People sorted by age");
        for(Person str: this.people){
            System.out.println(str);
        }
    }

    String GetName(){
        return this.name;
    }

    void SetName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s", GetName());
    }
}

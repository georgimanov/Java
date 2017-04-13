package com.company;

import java.util.*;

public class Institution {
    private String name = Constants.EMPTY_STRING;
    private Date date;
    private ArrayList<Person> people = new ArrayList<Person>();
    private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    private ArrayList<Student> students = new ArrayList<Student>();

    public Institution(){
    }

    public Institution(String name, Date date){
        setName(name);
        setDate(date);
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Date getDate(){
        return this.date;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public Integer getStudentsCount(){

        return this.students.size();
    }

    public void addStudent(Student student){
        this.people.add(student);
        this.students.add(student);
    }

    public void addTeacher(Teacher teacher){
        this.people.add(teacher);
        this.teachers.add(teacher);
    }

    public static Comparator<Institution> InstitutionStudentsCountComperator = new Comparator<Institution>() {
        public int compare(Institution p1, Institution p2) {
            //ascending order   //for descending order change order
            return p2.getStudentsCount() - p1.getStudentsCount();
        }
    };

    /*Comparator for sorting the list by age */
    public static Comparator<Institution> InstitutionDateComperator = new Comparator<Institution>() {
        public int compare(Institution p1, Institution p2) {
            Date birthday1 = p1.getDate();
            Date birthday2 = p2.getDate();

	   /*For ascending order*/
            // return birthday1.compareTo(birthday2);

	   /*For descending order*/
            return birthday2.compareTo(birthday1);
        }
    };

    public String forFileSave(){
        return String.format("Name: %s,Students count: %s, Teachers count: %s", getName(), getStudentsCount(), this.teachers.size());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("Type: %s \n", this.getClass().getSimpleName()));
        stringBuilder.append(String.format("Name: %s \n", this.getName()));
        stringBuilder.append(String.format("Date: %s \n", this.getDate()));
        stringBuilder.append(String.format("Students count: %s \n", getStudentsCount()));

        return stringBuilder.toString();
    }
}

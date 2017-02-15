package com.company;

import java.util.*;

public class Course {
    private String name = Constants.EMPTY_STRING;
    private ArrayList<Person> people = new ArrayList<Person>();
    private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    private ArrayList<Student> students = new ArrayList<Student>();

    private Map<Student, Integer> studentGrades = new HashMap<Student, Integer>();

    public Course(String name){
        this.name = name;
    }

    public void addStudent(Student student){
        this.people.add(student);
        this.students.add(student);
    }

    public void addTeacher(Teacher teacher){
        this.people.add(teacher);
        this.teachers.add(teacher);
    }

    public void addGradeToStudent(Student student, Integer grade){
        this.studentGrades.put(student, grade);
    }

    public Integer getGradeForStudent(Student student){
        return this.studentGrades.get(student);
    }

    public Integer getStudentsCount(){
        return this.students.size();
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void printDetailedCourseInfo(){
        Collections.sort(this.students, Person.PersonNameComparator);
        System.out.println(this.getName());
        for(Student student: this.students){
            System.out.println(student);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(" - %s \n", this.getName()));
        stringBuilder.append(" -- Teachers: \n");
        for(Iterator<Teacher> i = this.teachers.iterator(); i.hasNext(); ) {
            Teacher teacher = i.next();
            stringBuilder.append(" --- " + teacher.getName() + "\n");
        }

        return stringBuilder.toString();
    }
}

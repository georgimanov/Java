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

    public ArrayList<String> GetPeople(){
        ArrayList<String> peopleList = new ArrayList<String>();
        for(IPerson person: this.people){
            String personLine = GetPersonToPrint(person);
            peopleList.add(personLine);
        }
        return peopleList;
    }

    private String GetPersonToPrint(IPerson person){
        String role = person.getClass().getName();
        String roleResult = role.substring(role.length() - 7);

        return String.format("%s|%s|%s", roleResult, person.GetName(), person.GetBirthday());
    }

    public void AddStudent(Student student){
        this.people.add(student);
        this.students.add(student);
    }

    public void AddTeacher(Teacher teacher){
        this.people.add(teacher);
        this.teachers.add(teacher);
    }

    public void AddGradeToStudent(Student student, Integer grade){
        this.studentGrades.put(student, grade);
    }

    public Integer GetGradeForStudent(Student student){
        return this.studentGrades.get(student);
    }

    public Integer GetStudentsCount(){
        return this.students.size();
    }

    public void PrintPeopleSortedAlphabetically(){
        Collections.sort(this.people, Person.PersonNameComparator);

        System.out.println(this + " - People sorted by name");
        for(Person str: this.people){
            System.out.println(str);
        }
    }

    public void PrintPeopleSortedByAge(){
        Collections.sort(this.people, Person.PersonAgeComparator);

        System.out.println(this + " - People sorted by age");
        for(Person str: this.people){
            System.out.println(str);
        }
    }

    public String GetName(){
        return this.name;
    }

    public void SetName(String name){
        this.name = name;
    }

    public void PrintDetailedCourseInfo(){
        Collections.sort(this.students, Person.PersonNameComparator);
        System.out.println(this.GetName());
        for(Student student: this.students){
            System.out.println(student);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(" - %s \n", this.GetName()));
        stringBuilder.append(" -- Teachers: \n");
        for(Iterator<Teacher> i = this.teachers.iterator(); i.hasNext(); ) {
            Teacher teacher = i.next();
            stringBuilder.append(" --- " + teacher.GetName() + "\n");
        }

        return stringBuilder.toString();
    }
}

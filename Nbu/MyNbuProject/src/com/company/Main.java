package com.company;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        String datetimeStr1 = "1986-11-30";
        String datetimeStr2 = "1986-12-30";
        String datetimeStr3 = "1987-11-30";
        String datetimeStr4 = "1985-11-30";
        String datetimeStr5 = "1965-11-30";
        String datetimeStr6 = "1962-11-30";
        String datetimeStr7 = "1963-12-30";
        String datetimeStr8 = "1961-11-30";
        SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT);
        try {
            Date parseDate1 = format.parse(datetimeStr1);
            Date parseDate2 = format.parse(datetimeStr2);
            Date parseDate3 = format.parse(datetimeStr3);
            Date parseDate4 = format.parse(datetimeStr4);
            Date parseDate5 = format.parse(datetimeStr5);
            Date parseDate6 = format.parse(datetimeStr6);
            Date parseDate7 = format.parse(datetimeStr7);
            Date parseDate8 = format.parse(datetimeStr8);

            Student student1 = new Student("a", parseDate1);
            Student student2 = new Student("b", parseDate2);
            Student student3 = new Student("c", parseDate3);
            Student student4 = new Student("d", parseDate4);
            Student student5 = new Student("e", parseDate5);

            Teacher teacher1 = new Teacher("a", parseDate6);
            Teacher teacher2 = new Teacher("b", parseDate7);
            Teacher teacher3 = new Teacher("c", parseDate8);

            LearningSystem learningSystem = new LearningSystem();
            learningSystem.addPerson(student1);
            learningSystem.addPerson(student2);
            learningSystem.addPerson(student3);
            learningSystem.addPerson(student4);
            learningSystem.addPerson(student5);
            learningSystem.addPerson(teacher1);
            learningSystem.addPerson(teacher2);
            learningSystem.addPerson(teacher3);

            // problem 1
            learningSystem.printPeopleSortedAlphabetically();

            // problem 2
            learningSystem.printPeopleSortedByAge();

            Course course = new Course("Java Course");
            course.addStudent(student1);
            course.addStudent(student3);
            course.addStudent(student4);
            course.addStudent(student2);
            course.addStudent(student5);
            course.addTeacher(teacher1);
            course.addTeacher(teacher2);
            course.addTeacher(teacher3);

            Course course1 = new Course("JavaScript");

            student1.subscribeCourse(course1, teacher1);
            System.out.println(student1);

            student1.subscribeGrade(course1, teacher1, 5);
            System.out.println(student1);

            course.addGradeToStudent(student1, 5);

            teacher1.addCourse(course);
            teacher1.addCourse(course1);

            // problem 3
            System.out.print(student1);

            // problem 4
            System.out.print(teacher1);

            // save data to file
            DataManager dataManager = new DataManager();
            try{
                dataManager.savePeopleCollectionToFile("test.txt", learningSystem.getPeopleAsString());
            }catch (FileNotFoundException e){
                System.err.println("FileNotFoundException: " + e.getMessage());
            }

            // load data from file
            ArrayList<Person> input = dataManager.loadPeopleCollectionFromFile(Constants.FILE_PATH);

            for (Person person : input){
                System.out.println(person.getName());
            }

            // problem 5
            course.printDetailedCourseInfo();
        }
        catch (ParseException e) {
            System.err.println("ParseException: " + e.getMessage());
        }
    }
}

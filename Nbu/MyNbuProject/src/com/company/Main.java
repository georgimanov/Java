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
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
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

            Course course = new Course("Java Course");
            course.AddStudent(student1);
            course.AddStudent(student3);
            course.AddStudent(student4);
            course.AddStudent(student2);
            course.AddStudent(student5);
            course.AddTeacher(teacher1);
            course.AddTeacher(teacher2);
            course.AddTeacher(teacher3);

            Course course1 = new Course("JavaScript");

            student1.subscribeCourse(course1, teacher1);
            System.out.println(student1);

            student1.subscribeGrade(course1, teacher1, 100);
            System.out.println(student1);

            course.AddGradeToStudent(student1, 5);

            teacher1.AddCourse(course);
            teacher1.AddCourse(course1);

            //course.PrintPeopleSortedAlphabetically();
            //course.PrintPeopleSortedByAge();
            //System.out.print(teacher1);
            //System.out.print(student1);

            DataManager dataManager = new DataManager();
            try{
                dataManager.savePeopleCollectionToFile("test.txt", course.GetPeople());
            }catch (FileNotFoundException e){
                System.err.println("FileNotFoundException: " + e.getMessage());
            }
            ArrayList<Person> input = dataManager.loadPeopleCollectionFromFile(Constants.FILE_PATH);

            for (Person person : input){
                System.out.println(person.GetName());
            }

            course.PrintDetailedCourseInfo();
        }
        catch (ParseException e) {
            System.err.println("ParseException: " + e.getMessage());
        }
    }
}

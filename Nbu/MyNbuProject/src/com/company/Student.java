package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Student extends Person {
    private ArrayList<CourseTeacherGrade> courseTeacherGrades = new ArrayList<>();

    public Student(String name, Date birthday) {
        super(name, birthday);
    }

    public void subscribeCourse(Course course, Teacher teacher){
        CourseTeacherGrade newCTG = new CourseTeacherGrade(course, teacher);
        this.courseTeacherGrades.add(newCTG);
    }

    public void subscribeGrade(Course course, Teacher teacher, Integer grade){
        CourseTeacherGrade newCTG = new CourseTeacherGrade(course, teacher, grade);
        for(CourseTeacherGrade courseTeacherGrade : this.courseTeacherGrades){
            if(courseTeacherGrade.getCourseName().equalsIgnoreCase(newCTG.getCourseName()) &&
                    courseTeacherGrade.getTeacherName().equalsIgnoreCase(newCTG.getTeacherName())){
                courseTeacherGrade.setGrade(grade);
            }
        }
    }

    @Override
    public String toString() {
        String base = super.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(base);
        if(this.courseTeacherGrades.size() > 0){
            stringBuilder.append("\nCourses:\n");
            for (CourseTeacherGrade courseTeacherGrade : this.courseTeacherGrades){
                String courseName = courseTeacherGrade.getCourseName();
                Integer grade = courseTeacherGrade.getGrade();
                String teacherName = courseTeacherGrade.getTeacherName();
                stringBuilder.append(" - Course: " + courseName + " | Teacher: " + teacherName + " | Grade: " + (grade == null ? " unassigned " : grade));
            }
        }

        return stringBuilder.toString();
    }
}

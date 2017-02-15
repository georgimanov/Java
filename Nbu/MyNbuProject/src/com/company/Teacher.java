package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Teacher extends Person {
    protected ArrayList<Course> courses = new ArrayList<Course>();

    public Teacher(String name, Date birthday) {
        super(name, birthday);
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }

    @Override
    public String toString() {
        String base = super.toString();

        StringBuilder stringBuilder = new StringBuilder();
        if(this.courses.size() > 0){
            stringBuilder.append("\nCourses: \n");
            for(Iterator<Course> i = this.courses.iterator(); i.hasNext(); ) {
                Course course = i.next();
                stringBuilder.append(" - " + course.getName());
                Integer studentsCount = course.getStudentsCount();
                stringBuilder.append(" | Students count: " + studentsCount  + "\n" );
            }
        }

        return base + stringBuilder.toString();
    }
}

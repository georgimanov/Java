package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Teacher extends Person {
    protected ArrayList<Course> courses = new ArrayList<Course>();

    public Teacher(String name, Date birthday) {
        super(name, birthday);
    }

    public void AddCourse(Course course){
        this.courses.add(course);
    }

    @Override
    public String toString() {
        String base = super.toString();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Courses: \n");
        for(Iterator<Course> i = this.courses.iterator(); i.hasNext(); ) {
            Course course = i.next();
            stringBuilder.append(" - " + course.GetName());
            Integer studentsCount = course.GetStudentsCount();
            stringBuilder.append(" | Students count: " + studentsCount  + "\n" );
        }

        return base + stringBuilder.toString();
    }
}

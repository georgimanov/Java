package com.company;

import java.util.Comparator;

public class CourseTeacherGrade {
    private Teacher _teacher;
    private Integer _grade;
    private Course _course;

    public CourseTeacherGrade(Course course, Teacher teacher){
        _course = course;
        _teacher = teacher;
    }

    public CourseTeacherGrade(Course course, Teacher teacher, Integer grade) {
        this(course, teacher);
        _grade = grade;
    }

    public String getCourseName(){
        return this._course.getName();
    }

    public String getTeacherName(){
        return this._teacher.getName();
    }

    public Integer getGrade(){
        return this._grade;
    }

    public void setGrade(int grade){
        this._grade = grade;
    }

    public static Comparator<CourseTeacherGrade> CourseTeacherComparator = new Comparator<CourseTeacherGrade>() {
        public int compare(CourseTeacherGrade p1, CourseTeacherGrade p2) {
            String teacherName1 = p1._teacher.getName();
            String teacherName2 = p2._teacher.getName();
            String courseName1 = p1._course.getName();
            String courseName2 = p2._course.getName();

            return (teacherName1.compareTo(teacherName2)) & (courseName1.compareTo(courseName2));
        }
    };

    @Override
    public String toString() {
        return _teacher + " " + _grade;
    }
}
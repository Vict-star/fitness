package com.software.fitness.domain;

public class ClassTable {
    private CourseInfo[][] courseInfos;

    public void setCourseInfos(CourseInfo[][] courseInfos) {
        this.courseInfos = courseInfos;
    }

    public CourseInfo[][] getCourseInfos() {
        return courseInfos;
    }
}

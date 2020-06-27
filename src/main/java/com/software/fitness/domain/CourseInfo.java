package com.software.fitness.domain;

public class CourseInfo {
    private Course course;
    private Coach coach;

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Coach getCoach() {
        return coach;
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "CourseInfo{" +
                "course=" + course +
                ", coach=" + coach +
                '}';
    }
}

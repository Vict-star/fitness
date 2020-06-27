package com.software.fitness.domain;

public class CourseInfo {
    private Course course;
    private Coach coach;

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "CourseInfo{" +
                "course=" + course +
                ", coach=" + coach +
                '}';
    }
}

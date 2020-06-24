package com.software.fitness.domain;

public class Take_course {
    private int course_id;
    private int member_id;

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    @Override
    public String toString() {
        return "Take_course{" +
                "course_id=" + course_id +
                ", member_id=" + member_id +
                '}';
    }
}

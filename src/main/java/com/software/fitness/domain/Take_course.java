package com.software.fitness.domain;

public class Take_course {
	private int course_id;
	private int member_id;
	
    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int ID) {
        this.course_id = ID;
    }
    
    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int ID) {
        this.member_id = ID;
    }
    
    @Override
    public String toString() {
        return "Take_course{" +
                "course_id=" + course_id +
                ", member_id=" + member_id + 
                '}';
    }
}
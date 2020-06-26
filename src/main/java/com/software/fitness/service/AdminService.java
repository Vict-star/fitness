package com.software.fitness.service;

import com.software.fitness.domain.Coach;
import com.software.fitness.domain.Course;
import com.software.fitness.domain.Member;
import com.software.fitness.domain.Take_course;

import java.util.List;


public interface AdminService {
    Integer addCoach(Coach coach);

    List<Coach> coachPage();

    boolean dismissCoach(int id);

    Coach getCoach(int id);

    boolean updateCoach(Coach coach);

    boolean employCoach(Integer id);
    
    
    
    Member getMemberById(int id);
    
    Course getCourseById(int id);
    
    List<Course> coursePage();
    
    Integer addCourse(Course course);
    
    boolean updateCourse(Course course);
    
    boolean deleteCourse(int id);
    
    List<Take_course> getTakeByMemberid(int ID);
    
    List<Take_course> getTakeByCourseid(int ID);
    
    List<Take_course> getTakeAll();
    
    boolean addTake(Take_course take_course);
    
    boolean deleteTake(Take_course take_course);
    
}

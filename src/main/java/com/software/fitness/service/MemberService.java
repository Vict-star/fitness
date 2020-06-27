package com.software.fitness.service;

import com.software.fitness.domain.Coach;
import com.software.fitness.domain.Course;
import com.software.fitness.domain.Member;
import com.software.fitness.domain.Take_course;

import java.util.List;

public interface MemberService {

    Member getMemberByPhoneNumber(String phone_number);

    Integer updateMember(Member member);

    Integer insertTakeCourse(Take_course take_course);

    Integer deleteTakeCourse(Take_course take_course);

    List<Course> getAllCourse();

    List<Coach> getAllCoach();

    Integer updateMemberState();

    Integer updateCourseState();

}

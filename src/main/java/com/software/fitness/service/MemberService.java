package com.software.fitness.service;

import com.software.fitness.domain.*;

public interface MemberService {

    Member getMemberByPhoneNumber(String phone_number);

    Integer updateMember(Member member);

    Integer insertTakeCourse(Take_course take_course);

    Integer updateTakeCourse(Take_course take_course);

    Integer deleteTakeCourse(Take_course take_course);

    Course[] getAllCourse();

    Coach[] getAllCoach();

}

package com.software.fitness.service;

import com.software.fitness.domain.*;

public interface MemberService {
    Member getMemberByPhoneNumber(String phone_number);

    void updateMember(Member member);

    Integer insertTakeCourse(Take_course take_course);

    void updateTakeCourse(Take_course take_course);

    void deleteTakeCourse(Take_course take_course);

    Course[] getAllCourse();

    Coach[] getAllCoach();
}

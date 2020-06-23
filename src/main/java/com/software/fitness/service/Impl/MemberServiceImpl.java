package com.software.fitness.service.Impl;

import com.software.fitness.dao.MemberDao;
import com.software.fitness.domain.Coach;
import com.software.fitness.domain.Course;
import com.software.fitness.domain.Member;
import com.software.fitness.domain.Take_course;
import com.software.fitness.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDao memberDao;

    @Override
    public Member getMemberByPhoneNumber(String phone_number) {
        return null;
    }

    @Override
    public void updateMember(Member member) {

    }

    @Override
    public Integer insertTakeCourse(Take_course take_course) {
        return null;
    }

    @Override
    public void updateTakeCourse(Take_course take_course) {

    }

    @Override
    public void deleteTakeCourse(Take_course take_course) {

    }

    @Override
    public Course[] getAllCourse() {
        return new Course[0];
    }

    @Override
    public Coach[] getAllCoach() {
        return new Coach[0];
    }
}

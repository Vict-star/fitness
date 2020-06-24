package com.software.fitness.service.Impl;

import com.software.fitness.dao.CoachDao;
import com.software.fitness.dao.CourseDao;
import com.software.fitness.dao.MemberDao;
import com.software.fitness.dao.Take_courseDao;
import com.software.fitness.domain.Coach;
import com.software.fitness.domain.Course;
import com.software.fitness.domain.Member;
import com.software.fitness.domain.Take_course;
import com.software.fitness.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private Take_courseDao take_courseDao;
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private CoachDao coachDao;

    @Override
    public Member getMemberByPhoneNumber(String phone_number) {
        return memberDao.getMemberByPhoneNumber(phone_number);
    }

    @Override
    public Integer updateMember(Member member) {
        return memberDao.update(member);
    }

    @Override
    public Integer insertTakeCourse(Take_course take_course) {
        return take_courseDao.insert(take_course);
    }

    @Override
    public Integer deleteTakeCourse(Take_course take_course) {
        return take_courseDao.delete(take_course);
    }

    @Override
    public Course[] getAllCourse() {
        return courseDao.getAllCourse();
    }

    @Override
    public Coach[] getAllCoach() {
        return coachDao.getAllCoach();
    }
}

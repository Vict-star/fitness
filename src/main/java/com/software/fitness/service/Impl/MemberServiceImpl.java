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
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public List<Course> getAllCourse() {
        return courseDao.getAllCourse();
    }

    @Override
    public List<Coach> getAllCoach() {
        return coachDao.getAllCoach();
    }

    @Override
    public Integer updateMemberState() {
        Integer v = memberDao.updateValidityState(), i = memberDao.updateInvalidityState();
        return v > i ? i : v;
    }

    @Override
    public Integer updateCourseState() {
        Integer v = courseDao.updateStartState(), i = courseDao.updateEndState();
        return v > i ? i : v;
    }
}

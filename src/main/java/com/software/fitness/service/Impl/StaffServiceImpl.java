package com.software.fitness.service.Impl;

import com.software.fitness.dao.*;
import com.software.fitness.domain.*;
import com.software.fitness.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;
    @Autowired
    private CoachDao coachDao;
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private Take_courseDao take_courseDao;
    @Autowired
    private AttendanceDao attendanceDao;
    @Autowired
    private Time_slotDao time_slotDao;


    @Override
    public Staff getStaffByPhoneNumber(String phone_number) {
        return staffDao.getStaffByPhoneNumber(phone_number);
    }

    @Override
    public Integer insertStaff(Staff staff) {
        return staffDao.insert(staff);
    }

    @Override
    public Integer updateStaff(Staff staff) {
        return staffDao.update(staff);
    }

    @Override
    public Integer deleteStaff(Staff staff) {
        return staffDao.delete(staff);
    }

    @Override
    public Staff[] getAllStaff() {
        return staffDao.getAllStaff();
    }

    @Override
    public Integer insertCoach(Coach coach) {
        return coachDao.insert(coach);
    }

    @Override
    public Integer updateCoach(Coach coach) {
        return coachDao.update(coach);
    }

    @Override
    public Integer deleteCoach(Coach coach) {
        return coachDao.delete(coach);
    }

    @Override
    public Coach[] getAllCoach() {
        return coachDao.getAllCoach();
    }

    @Override
    public Coach getCoachByID(int id) {
        return coachDao.getCoachByID(id);
    }

    @Override
    public Integer insertMember(Member member) {
        return memberDao.insert(member);
    }

    @Override
    public Integer updateMember(Member member) {
        return memberDao.update(member);
    }

    @Override
    public Integer deleteMember(Member member) {
        return memberDao.delete(member);
    }

    @Override
    public Member getMemberByID(int id) {
        return memberDao.getMemberByID(id);
    }

    @Override
    public Member getMemberByPhoneNumber(String phone_number) {
        return memberDao.getMemberByPhoneNumber(phone_number);
    }

    @Override
    public Member[] getMemberByCourseID(int id) {
        return memberDao.getMemberByCourseID(id);
    }

    @Override
    public Integer increaseNumberOfCourses(int id) {
        return memberDao.increaseNumberOfCourse(id);
    }

    @Override
    public Integer decreaseNumberOfCourses(int id) {
        return memberDao.decreaseNumberOfCourse(id);
    }

    @Override
    public Member[] getAllMember() {
        return memberDao.getAllMember();
    }

    @Override
    public Integer insertCourse(Course course) {
        return courseDao.insert(course);
    }

    @Override
    public Integer updateCourse(Course course) {
        return courseDao.update(course);
    }

    @Override
    public Integer deleteCourse(Course course) {
        return courseDao.delete(course);
    }

    @Override
    public Course getCourseByID(int id) {
        return courseDao.getCourseByID(id);
    }

    @Override
    public Integer increaseNumberOfMember(int id) {
        return courseDao.increaseNumberOfMember(id);
    }

    @Override
    public Integer decreaseNumberOfMember(int id) {
        return courseDao.decreaseNumberOfMember(id);
    }

    @Override
    public Course[] getAllCourse() {
        return courseDao.getAllCourse();
    }

    @Override
    public Integer insertTimeSlot(Time_slot time_slot) {
        return time_slotDao.insert(time_slot);
    }

    @Override
    public Integer updateTimeSlot(Time_slot time_slot) {
        return time_slotDao.update(time_slot);
    }

    @Override
    public Integer deleteTimeSlot(Time_slot time_slot) {
        return time_slotDao.delete(time_slot);
    }

    @Override
    public Time_slot[] getAllTimeSlot() {
        return time_slotDao.getAllTimeSlot();
    }

    @Override
    public Integer insertAttendance(Attendance attendance) {
        return attendanceDao.insert(attendance);
    }

    @Override
    public Integer deleteAttendance(Attendance attendance) {
        return attendanceDao.delete(attendance);
    }

    @Override
    public Integer insertTakeCourse(Take_course take_course) {
        return take_courseDao.insert(take_course);
    }

    @Override
    public Integer deleteTakeCourse(Take_course take_course) {
        return take_courseDao.delete(take_course);
    }

}

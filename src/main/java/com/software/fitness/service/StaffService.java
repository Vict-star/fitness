package com.software.fitness.service;


import com.software.fitness.domain.*;
import com.software.fitness.page.PageRequest;
import com.software.fitness.page.PageResult;

import java.util.Date;
import java.util.List;

/**
 * StaffService
 * 包括所有表的操作接口
 */

public interface StaffService {

    Staff getStaffByPhoneNumber(String phone_number);

    //Admin级权限
    Integer insertStaff(Staff staff);

    Integer updateStaff(Staff staff);

    Integer deleteStaff(Staff staff);

    List<Staff> getAllStaff();

    Integer insertCoach(Coach coach);

    Integer updateCoach(Coach coach);

    Integer deleteCoach(Coach coach);

    List<Coach> getAllCoach();

    Coach getCoachByID(int id);

    Integer insertMember(Member member);

    Integer updateMember(Member member);

    Integer deleteMember(Member member);

    Member getMemberByID(int id);

    Member getMemberByPhoneNumber(String phone_number);

    List<Member> getMemberByCourseID(int id);

    @Deprecated
    Integer increaseNumberOfCourses(int id);

    @Deprecated
    Integer decreaseNumberOfCourses(int id);

    List<Member> getAllMember();

    Integer insertCourse(Course course);

    Integer updateCourse(Course course);

    Integer deleteCourse(Course course);

    Course getCourseByID(int id);

    @Deprecated
    Integer increaseNumberOfMember(int id);

    @Deprecated
    Integer decreaseNumberOfMember(int id);

    List<Course> getAllCourse();

    List<Course> getCourseByState(String state);

    Integer insertTimeSlot(Time_slot time_slot);

    Integer updateTimeSlot(Time_slot time_slot);

    Integer deleteTimeSlot(Time_slot time_slot);

    List<Time_slot> getAllTimeSlot();

    Integer insertAttendance(Attendance attendance);

    Integer deleteAttendance(Attendance attendance);

    Integer insertTakeCourse(Take_course take_course);

    Integer deleteTakeCourse(Take_course take_course);

    PageResult getMemberPage(PageRequest pageRequest);

    List<Course> getCourseByDate(Date date);

    List<Course> getCourseByMemberID(int id);

    List<CourseTableItem> listCourseTableItem();

    List<CourseChosenItem> listCourseChosenItem(Integer course_id);

    Time_slot getTimeSlotByTime(Time time);

    Attendance checkAttendance(Attendance attendance);
}

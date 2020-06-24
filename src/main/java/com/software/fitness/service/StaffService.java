package com.software.fitness.service;


import com.software.fitness.domain.*;

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

    Staff[] getAllStaff();

    Integer insertCoach(Coach coach);

    Integer updateCoach(Coach coach);

    Integer deleteCoach(Coach coach);

    Coach[] getAllCoach();

    Integer insertMember(Member member);

    Integer updateMember(Member member);

    Integer deleteMember(Member member);

    Member getMemberByID(int id);

    Member getMemberByPhoneNumber(String phone_number);

    Integer increaseNumberOfCourses(int id);

    Integer decreaseNumberOfCourses(int id);

    Member[] getAllMember();

    Integer insertCourse(Course course);

    Integer updateCourse(Course course);

    Integer deleteCourse(Course course);

    Course getCourseByID(int id);

    Integer increaseNumberOfMember(int id);

    Integer decreaseNumberOfMember(int id);

    Course[] getAllCourse();

    Integer insertTimeSlot(Time_slot time_slot);

    Integer updateTimeSlot(Time_slot time_slot);

    Integer deleteTimeSlot(Time_slot time_slot);

    Time_slot[] getAllTimeSlot();

    Integer insertAttendance(Attendance attendance);

    Integer deleteAttendance(Attendance attendance);

    Integer insertTakeCourse(Take_course take_course);

    Integer deleteTakeCourse(Take_course take_course);

}

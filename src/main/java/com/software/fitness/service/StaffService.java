package com.software.fitness.service;


import com.github.pagehelper.PageInfo;
import com.software.fitness.domain.*;

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

    Staff[] getAllStaff();

    Integer insertCoach(Coach coach);

    Integer updateCoach(Coach coach);

    Integer deleteCoach(Coach coach);

    Coach[] getAllCoach();

    Coach getCoachByID(int id);

    Integer insertMember(Member member);

    Integer updateMember(Member member);

    Integer deleteMember(Member member);

    Member getMemberByID(int id);

    Member getMemberByPhoneNumber(String phone_number);

    Member[] getMemberByCourseID(int id);

    @Deprecated
    Integer increaseNumberOfCourses(int id);

    @Deprecated
    Integer decreaseNumberOfCourses(int id);

    Member[] getAllMember();

    Integer insertCourse(Course course);

    Integer updateCourse(Course course);

    Integer deleteCourse(Course course);

    Course getCourseByID(int id);

    @Deprecated
    Integer increaseNumberOfMember(int id);

    @Deprecated
    Integer decreaseNumberOfMember(int id);

    Course[] getAllCourse();

    Course[] getCourseByState(String state);

    Integer insertTimeSlot(Time_slot time_slot);

    Integer updateTimeSlot(Time_slot time_slot);

    Integer deleteTimeSlot(Time_slot time_slot);

    Time_slot[] getAllTimeSlot();

    Integer insertAttendance(Attendance attendance);

    Integer deleteAttendance(Attendance attendance);

    Integer insertTakeCourse(Take_course take_course);

    Integer deleteTakeCourse(Take_course take_course);

    List<CourseTableItem> listCourseTableItem();

    List<CourseChosenItem> listCourseChosenItem(Integer course_id);

    PageInfo<Coach> PageAllCoach(int page,int pageSize);

    boolean changePassword(String phone_number, String staffId, String old_pwd, String new_pwd);

    boolean staffDetailUpdate(String id,String name, String phone_number, String address);
}

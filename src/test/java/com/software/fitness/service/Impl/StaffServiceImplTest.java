package com.software.fitness.service.Impl;

import com.software.fitness.domain.*;
import com.software.fitness.service.StaffService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.List;

@SpringBootTest
class StaffServiceImplTest {
    @Autowired
    StaffService staffService;

    @Test
    void listCourseTableItem() {
        List<CourseTableItem> list = staffService.listCourseTableItem();
        System.out.println(list.size());
    }

    @Test
    void getStaffByPhoneNumber() {
        Staff staff = staffService.getStaffByPhoneNumber("137");
        System.out.println(staff.toString());
    }

    @Test
    void insertStaff() {
        Staff staff = new Staff();
        staff.setPassword("11111111111111111111");
        staff.setPhone_number("22222222222222222222");
        staff.setName("33333333333333333333");
        staff.setIs_admin("是");
        staff.setAddress("44444444444444444444");
        try {
            assert (staffService.insertStaff(staff) > 0);
        } catch (Exception e) {

        }

        assert (staff.getId() > 0);
        System.out.println(staff);
    }

    @Test
    void updateStaff() {
        Staff staff = new Staff();
        staff.setId(3);
        staff.setPhone_number("13500000001");
        staffService.updateStaff(staff);
        System.out.println(staff);
        System.out.println(staffService.getStaffByPhoneNumber("13500000001"));
    }

    @Test
    void deleteStaff() {
        Staff staff = new Staff();
        staff.setId(10);
        staffService.deleteStaff(staff);
        System.out.println(staff);
    }

    @Test
    void getAllStaff() {
        System.out.println(staffService.getAllStaff());
    }

    @Test
    void insertCoach() {
        Coach coach = new Coach();
        coach.setAddress("Address");
        coach.setDate_of_birth(Calendar.getInstance().getTime());
        coach.setGender("男");
        coach.setIntroduction("Introduction");
        coach.setName("Name");
        coach.setPhone_number("1234567890");
        assert (staffService.insertCoach(coach) > 0);
        System.out.println(coach);
    }

    @Test
    void updateCoach() {
        Coach coach = new Coach();
        coach.setId(5);
        coach.setState("离职");
        assert (staffService.updateCoach(coach) > 0);
        System.out.println(coach);
    }

    @Test
    void deleteCoach() {
        Coach coach = new Coach();
        coach.setId(5);
        assert (staffService.deleteCoach(coach) > 0);
        System.out.println(coach);
    }

    @Test
    void getAllCoach() {
        System.out.println(staffService.getAllCoach());
    }

    @Test
    void getCoachByID() {
        System.out.println(staffService.getCoachByID(5));
    }

    @Test
    void insertMember() {
        Member member = new Member();
        member.setName("NAME");
        member.setDate_of_birth(Calendar.getInstance().getTime());
        member.setGender("男");
        member.setPhone_number("12345678901");
        member.setValidity(Calendar.getInstance().getTime());
        member.setPassword("PASSWORD");
        int i = staffService.insertMember(member);
        if (i > 0) {
            System.out.println("插入成功");
        } else {
            System.out.println("电话号码冲突");
        }
        System.out.println(member);
    }

    @Test
    void updateMember() {
        Member member = new Member();
        member.setId(6);
        member.setPassword("NEWPASSWORD");
        member.setPhone_number("NEWPHONE");
        member.setState("已注销");
        member.setGender("女");
        member.setName("新名字");
        int i = staffService.updateMember(member);
        if (i > 0) {
            System.out.println("更新成功");
        } else {
            System.out.println("没有");
        }
        System.out.println(member);
    }

    @Test
    void deleteMember() {
        Member member = new Member();
        member.setId(6);
        int i = staffService.updateMember(member);
        if (i > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("没有");
        }
        System.out.println(member);
    }

    @Test
    void getMemberByID() {
        System.out.println(staffService.getMemberByID(6));
    }

    @Test
    void getMemberByPhoneNumber() {
        System.out.println(staffService.getMemberByPhoneNumber("12345678901"));
    }

    @Test
    void getMemberByCourseID() {
        System.out.println(staffService.getMemberByCourseID(1));
    }

    @Test
    void getAllMember() {
        System.out.println(staffService.getAllMember());
    }

    @Test
    void insertCourse() {
        Course course = new Course();
        course.setCapacity(400);
        course.setDescription("Description");
        course.setEnd_date(Calendar.getInstance().getTime());
        course.setStart_date(Calendar.getInstance().getTime());
        course.setRoom_number("room number");
        course.setName("NAME");
        course.setCoach_id(2);
        course.setTime_slot_id(1);
        int i = staffService.insertCourse(course);
        if (i > 0) {
            System.out.println("插入成功");
        } else {
            System.out.println("没有");
        }
        System.out.println(course);
    }

    @Test
    void updateCourse() {
        Course course = new Course();
        course.setId(5);
        course.setName("NEW");
        course.setCapacity(1000);
        course.setRoom_number("new room number");
        course.setState("已结课");
        course.setDescription("new Description");
        int i = staffService.updateCourse(course);
        if (i > 0) {
            System.out.println("更新成功");
        } else {
            System.out.println("没有");
        }
        System.out.println(course);
    }

    @Test
    void deleteCourse() {
        Course course = new Course();
        course.setId(5);
        int i = staffService.deleteCourse(course);
        if (i > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("没有");
        }
        System.out.println(course);
    }

    @Test
    void getCourseByID() {
        System.out.println(staffService.getCourseByID(5));
    }

    @Test
    void getAllCourse() {
        System.out.println(staffService.getAllCourse());
    }

    @Test
    void getCourseByState() {
        System.out.println(staffService.getCourseByState("正在上课"));
    }

    @Test
    void insertTimeSlot() {
        Time_slot time_slot = new Time_slot();
        time_slot.setDay("周六");
        time_slot.setId(99);
        time_slot.setStart_time(Calendar.getInstance().getTime());
        time_slot.setEnd_time(Calendar.getInstance().getTime());
        int i = staffService.insertTimeSlot(time_slot);
        if (i > 0) {
            System.out.println("插入成功");
        } else {
            System.out.println("没有");
        }
        System.out.println(time_slot);
    }

    @Test
    void deleteTimeSlot() {
        Time_slot time_slot = new Time_slot();
        time_slot.setDay("周六");
        time_slot.setId(99);
        time_slot.setStart_time(Calendar.getInstance().getTime());
        time_slot.setEnd_time(Calendar.getInstance().getTime());
        int i = staffService.deleteTimeSlot(time_slot);
        if (i > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("没有");
        }
        System.out.println(time_slot);
    }

    @Test
    void getAllTimeSlot() {
        System.out.println(staffService.getAllTimeSlot());
    }

    @Test
    void insertTakeCourse() {
        Take_course take_course = new Take_course();
        take_course.setCourse_id(4);
        take_course.setMember_id(2);
        int i = staffService.insertTakeCourse(take_course);
        if (i > 0) {
            System.out.println("插入成功");
        } else {
            System.out.println("没有");
        }
        System.out.println(take_course);
    }

    @Test
    void deleteTakeCourse() {
        Take_course take_course = new Take_course();
        take_course.setCourse_id(4);
        take_course.setMember_id(2);
        int i = staffService.deleteTakeCourse(take_course);
        if (i > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("没有");
        }
        System.out.println(take_course);
    }

    @Test
    void getCourseByDate() {
        System.out.println(staffService.getCourseByDate(Calendar.getInstance().getTime()));
    }

    @Test
    void getCourseByMemberID() {
        System.out.println(staffService.getCourseByMemberID(2));
    }

    @Test
    void listCourseChosenItem() {
        System.out.println(staffService.listCourseChosenItem(4));
    }

    @Test
    void pageAllCoach() {
        System.out.println(staffService.PageAllCoach(1, 10));
    }

    @Test
    void getTimeSlotByTime() {
        Time time = new Time(Calendar.getInstance().getTime(), "周一");
        System.out.println(staffService.getTimeSlotByTime(time));
    }

    @Test
    void checkAttendance() {
        Attendance attendance = new Attendance();
        attendance.setDate_of_attendance(Calendar.getInstance().getTime());
        attendance.setMember_id(2);
        attendance.setCourse_id(4);
        System.out.println(staffService.checkAttendance(attendance));
    }
}
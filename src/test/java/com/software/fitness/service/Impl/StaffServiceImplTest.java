package com.software.fitness.service.Impl;

import com.software.fitness.domain.CourseTableItem;
import com.software.fitness.domain.Staff;
import com.software.fitness.service.StaffService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    }

    @Test
    void insertCoach() {
    }

    @Test
    void updateCoach() {
    }

    @Test
    void deleteCoach() {
    }

    @Test
    void getAllCoach() {
    }

    @Test
    void getCoachByID() {
    }

    @Test
    void insertMember() {
    }

    @Test
    void updateMember() {
    }

    @Test
    void deleteMember() {
    }

    @Test
    void getMemberByID() {
    }

    @Test
    void getMemberByPhoneNumber() {
    }

    @Test
    void getMemberByCourseID() {
    }

    @Test
    void increaseNumberOfCourses() {
    }

    @Test
    void decreaseNumberOfCourses() {
    }

    @Test
    void getAllMember() {
    }

    @Test
    void insertCourse() {
    }

    @Test
    void updateCourse() {
    }

    @Test
    void deleteCourse() {
    }

    @Test
    void getCourseByID() {
    }

    @Test
    void increaseNumberOfMember() {
    }

    @Test
    void decreaseNumberOfMember() {
    }

    @Test
    void getAllCourse() {
    }

    @Test
    void getCourseByState() {
    }

    @Test
    void insertTimeSlot() {
    }

    @Test
    void updateTimeSlot() {
    }

    @Test
    void deleteTimeSlot() {
    }

    @Test
    void getAllTimeSlot() {
    }

    @Test
    void insertAttendance() {
    }

    @Test
    void deleteAttendance() {
    }

    @Test
    void insertTakeCourse() {
    }

    @Test
    void deleteTakeCourse() {
    }

    @Test
    void getMemberPage() {
    }

    @Test
    void getCourseByDate() {
    }

    @Test
    void getCourseByMemberID() {
    }

    @Test
    void testListCourseTableItem() {
    }

    @Test
    void listCourseChosenItem() {
    }

    @Test
    void pageAllCoach() {
    }

    @Test
    void changePassword() {
    }

    @Test
    void getTimeSlotByTime() {
    }

    @Test
    void checkAttendance() {
    }

    @Test
    void staffDetailUpdate() {
    }
}
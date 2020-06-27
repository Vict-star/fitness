package com.software.fitness;

import com.software.fitness.domain.Member;
import com.software.fitness.domain.Staff;
import com.software.fitness.service.MemberService;
import com.software.fitness.service.StaffService;
import com.software.fitness.utils.DateUtils;
import org.assertj.core.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootTest
class FitnessApplicationTests {
    @Autowired
    private StaffService staffService;
    @Autowired
    private MemberService memberService;

    @Test
    void getStaff() {
        Staff staff = staffService.getStaffByPhoneNumber("13609063091");
        System.out.println(staff.toString());

        List<Staff> staffs = staffService.getAllStaff();
        for (Staff s : staffs) {
            System.out.println(s);
        }
    }

    @Test
    void iudStaff() {
        Staff staff = new Staff();
        staff.setPassword("123");
        staff.setAddress("北京市");
        staff.setIs_admin("是");
        staff.setName("凉凉");
        staff.setPhone_number("119");
        Integer integer = staffService.insertStaff(staff);
        System.out.println("insert return value is " + integer);
        System.out.println("staff id is " + staff.getId());
        staff.setPhone_number("110");
        integer = staffService.updateStaff(staff);
        System.out.println("update return value is " + integer);
        integer = staffService.deleteStaff(staff);
        System.out.println("delete return value is " + integer);
    }

    @Test
    void getMember() {

        List<Member> members = staffService.getAllMember();
        for (Member m : members) {
            System.out.println(m);
        }
    }

    @Test
    void dawd() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR,-12);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);
        cal.set(Calendar.MILLISECOND,0);
        System.out.println(new DateUtils().getThisMonday(cal.getTime()));
        System.out.println(cal.getTime());
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        System.out.println(cal.getFirstDayOfWeek());
        System.out.println(cal.get(Calendar.DAY_OF_WEEK));
    }
}

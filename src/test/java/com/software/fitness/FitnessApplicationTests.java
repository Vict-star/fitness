package com.software.fitness;

import com.software.fitness.domain.Staff;
import com.software.fitness.service.StaffService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FitnessApplicationTests {
    @Autowired
    private StaffService staffService;

    @Test
    void contextLoads() {
    }

    //    测试获取用户
    @Test
    void testGetUser() {
        Staff user = staffService.getStaffByPhoneNumber("123456");
        System.out.print(user);
    }
}

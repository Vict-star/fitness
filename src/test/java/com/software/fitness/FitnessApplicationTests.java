package com.software.fitness;

import com.software.fitness.domain.Staff;
import com.software.fitness.domain.User;
import com.software.fitness.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FitnessApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
    }

    //    测试获取用户
    @Test
    void testGetUser() {
        Staff user = userService.getStaffById("123456");
        System.out.print(user);
    }
}

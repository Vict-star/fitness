package com.software.fitness.service.Impl;

import com.software.fitness.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdminServiceImplTest {
    @Autowired
    AdminService adminService;

    @Test
    void pageStaff() {
        System.out.println(adminService.PageStaff());
    }

    @Test
    void getStaffByID() {
        System.out.println(adminService.getStaffByID(1));
    }
}
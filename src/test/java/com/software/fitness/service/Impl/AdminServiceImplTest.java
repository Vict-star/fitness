package com.software.fitness.service.Impl;

import com.software.fitness.domain.Coach;
import com.software.fitness.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminServiceImplTest {
    @Autowired
    AdminService adminService;
    @Test
    void addCoach() {
        Coach coach = new Coach();
        coach.setName("zcf");
        coach.setState("在职");
        coach.setGender("男");
        coach.setDate_of_birth(Date.valueOf("2020-06-23"));
        coach.setAddress("纽约");
        coach.setIntroduction("高富帅");
        coach.setPhone_number("19927522504");
        adminService.addCoach(coach);
    }

    @Test
    void getCoach() {
        Coach coach = adminService.getCoach(123462);
        System.out.println(coach);
    }

    @Test
    void updateCoach() {
        Coach coach = adminService.getCoach(123462);
        System.out.println(coach);
        coach.setIntroduction("高富帅 渣男 aeiajgeij");
        boolean result = adminService.updateCoach(coach);
        System.out.println(result);
    }
}
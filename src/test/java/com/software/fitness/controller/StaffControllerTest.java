package com.software.fitness.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StaffControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() throws Exception{
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();//建议使用这种
    }

    @Test
    void coachManagePage() {
    }

    @Test
    void staffDetailPage() {
    }

    @Test
    void staffDetailUpdate() {
    }

    @Test
    void passwordManage() {
    }

    @Test
    void passwordChange() {
    }

    @Test
    void memberManagePage() {
    }

    @Test
    void memberEditPage() {
    }

    @Test
    void attendancePage() {
    }

    @Test
    void attendanceSignPage() {
    }

    @Test
    void classTablePage() {
    }

    @Test
    void chooseClassPage() {
    }

    @Test
    void courseManagePage() {
    }

    @Test
    void courseEditPage() {
    }

    @Test
    void staffManagePage() {
    }

    @Test
    void historyPage() {
    }

    @Test
    void coachEditPage() {
    }

    @Test
    void addCoach() {
    }

    @Test
    void editCoach() {
    }

    @Test
    void dismissCoach() {
    }

    @Test
    void employCoach() {
    }

    @Test
    void updateCoach() {
    }

    @Test
    void cancelMember() {
    }

    @Test
    void activateMember() {
    }

    @Test
    void updateMember() {
    }

    @Test
    void attendanceSign() {
    }

    @Test
    void addMember() {
    }

    @Test
    void editMember() {
    }

    @Test
    void testAttendanceSign() {
    }

    @Test
    void addCourse() {
    }

    @Test
    void editCourse() {
    }

    @Test
    void cancelCourse() {
    }

    @Test
    void testCancelCourse() {
    }

    @Test
    void pickClass() {
    }

    @Test
    void quitClassPage() {
    }

    @Test
    void quitClass() {
    }

    @Test
    void addStaff() {
    }

    @Test
    void editStaff() {
    }
}
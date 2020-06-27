package com.software.fitness.service.Impl;

import com.software.fitness.dao.CourseDao;
import com.software.fitness.domain.CourseTableItem;
import com.software.fitness.service.StaffService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StaffServiceImplTest {
    @Autowired
    StaffService staffService;
    @Autowired
    CourseDao courseDao;
    @Test
    void listCourseTableItem() {
        List<CourseTableItem> list = courseDao.listCourseTableItem();
        System.out.println(list.size());
    }
}
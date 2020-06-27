package com.software.fitness.dao;

import com.software.fitness.domain.CourseChosenItem;
import com.software.fitness.domain.Take_course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface Take_courseDao {

    Integer insert(Take_course take_course);

    Integer delete(Take_course take_course);

    List<CourseChosenItem> listCourseChosenItem(Integer course_id);
}

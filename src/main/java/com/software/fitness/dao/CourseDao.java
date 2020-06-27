package com.software.fitness.dao;

import com.software.fitness.domain.Course;
import com.software.fitness.domain.CourseTableItem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
@Mapper
public interface CourseDao {

    Integer insert(Course course);

    Integer update(Course course);

    Integer delete(Course course);

    Course getCourseByID(int id);

    @Deprecated
    Integer increaseNumberOfMember(int id);

    @Deprecated
    Integer decreaseNumberOfMember(int id);

    List<Course> getAllCourse();

    List<Course> getCourseByState(String state);

    Integer updateEndState();

    Integer updateStartState();

    List<CourseTableItem> listCourseTableItem();

    List<Course> getCourseByDate(Date date);

    List<Course> getCourseByMemberID(int id);
}

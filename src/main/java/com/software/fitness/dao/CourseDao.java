package com.software.fitness.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.software.fitness.domain.Course;

@Repository
@Mapper
public interface CourseDao {

    List<Course> listCourse();

    Course getCourseById(int id);
    
    Integer addCourse(Course course);

    Integer updateCourse(Course course);
    
    Integer deleteCourse(int id);
    
    @Deprecated
    Integer increaseNumberOfMember(int id);

    @Deprecated
    Integer decreaseNumberOfMember(int id);
}

package com.software.fitness.dao;

import com.software.fitness.domain.Take_course;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface Take_courseDao {

    Integer insert(Take_course take_course);

    Integer delete(Take_course take_course);

	List<Take_course> getTakeByMemberId(int iD);

	List<Take_course> getTakeByCourseId(int iD);

	List<Take_course> getTakeAll();
    
}

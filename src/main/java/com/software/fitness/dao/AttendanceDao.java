package com.software.fitness.dao;

import com.software.fitness.domain.Attendance;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AttendanceDao {

    Integer insert(Attendance attendance);

    Integer update(Attendance attendance);

    Integer delete(Attendance attendance);
}

package com.software.fitness.dao;

import com.software.fitness.domain.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {
    Staff getStaffById(String ID);
}

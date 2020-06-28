package com.software.fitness.dao;

import com.software.fitness.domain.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StaffDao {

    Staff getStaffByPhoneNumber(String phone_number);

    Integer insert(Staff staff);

    Integer update(Staff staff);

    Integer delete(Staff staff);

    List<Staff> getAllStaff();

    Staff getStaffByID(int id);
}

package com.software.fitness.dao;

import com.software.fitness.domain.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface StaffDao {

    Staff getStaffByPhoneNumber(String phone_number);

    Integer insert(Staff staff);

    Integer update(Staff staff);

    Integer delete(Staff staff);

    Staff[] getAllStaff();

}

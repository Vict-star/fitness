package com.software.fitness.service.Impl;


import com.software.fitness.dao.StaffDao;
import com.software.fitness.domain.Staff;
import com.software.fitness.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    StaffDao staffDao;

    @Override
    public List<Staff> PageStaff() {
        return staffDao.getAllStaff();
    }

    @Override
    public Staff getStaffByID(int id) {
        return staffDao.getStaffByID(id);
    }


}

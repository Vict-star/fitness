package com.software.fitness.service.Impl;

import com.software.fitness.dao.UserDao;
import com.software.fitness.domain.Staff;
import com.software.fitness.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Staff getStaffById(String ID) {
        return userDao.getStaffById(ID);
    }
}

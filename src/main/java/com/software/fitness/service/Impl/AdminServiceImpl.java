package com.software.fitness.service.Impl;

import com.software.fitness.dao.CoachDao;
import com.software.fitness.domain.Coach;
import com.software.fitness.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private CoachDao coachDao;

    @Override
    public Integer addCoach(Coach coach) {
        Integer id = -1;
        id = coachDao.addCoach(coach);
        return id;
    }
}

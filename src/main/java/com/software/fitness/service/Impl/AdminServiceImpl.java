package com.software.fitness.service.Impl;

import com.software.fitness.dao.CoachDao;
import com.software.fitness.domain.Coach;
import com.software.fitness.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Coach> coachPage() {
        return coachDao.listCoach();
    }

    @Override
    public boolean dismissCoach(int id) {
        Coach coach = coachDao.getCoach(id);
        coach.setState("离职");
        int row  = coachDao.updateCoach(coach);
        return row == 1;
    }

    @Override
    public boolean employCoach(Integer id) {
        Coach coach = coachDao.getCoach(id);
        coach.setState("在职");
        int row  = coachDao.updateCoach(coach);
        return row == 1;
    }

    @Override
    public Coach getCoach(int id) {
        return coachDao.getCoach(id);
    }

    @Override
    public boolean updateCoach(Coach coach) {
        int row = coachDao.updateCoach(coach);
        return row == 1;
    }


}

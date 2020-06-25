package com.software.fitness.service;

import com.software.fitness.domain.Coach;

import java.util.List;


public interface AdminService {
    Integer addCoach(Coach coach);

    List<Coach> coachPage();

    boolean dismissCoach(int id);

    Coach getCoach(int id);

    boolean updateCoach(Coach coach);

    boolean employCoach(Integer id);
}

package com.software.fitness.dao;

import com.software.fitness.domain.Coach;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CoachDao {

    Integer insert(Coach coach);

    Integer update(Coach coach);

    Integer delete(Coach coach);

    Coach[] getAllCoach();

    Coach getCoachByID(int id);
}

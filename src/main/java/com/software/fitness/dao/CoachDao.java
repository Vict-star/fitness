package com.software.fitness.dao;

import com.software.fitness.domain.Coach;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CoachDao {
    Integer addCoach(Coach coach);

    List<Coach> listCoach();

    Coach getCoach(int id);

    int updateCoach(Coach coach);
}

package com.software.fitness.dao;

import com.software.fitness.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {
    User getUserById(String userId);
}

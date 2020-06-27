package com.software.fitness.dao;

import com.software.fitness.domain.Time_slot;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface Time_slotDao {
    Integer insert(Time_slot time_slot);

    Integer update(Time_slot time_slot);

    Integer delete(Time_slot time_slot);

    List<Time_slot> getAllTimeSlot();
}

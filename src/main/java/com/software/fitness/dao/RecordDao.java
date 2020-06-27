package com.software.fitness.dao;

import com.software.fitness.domain.Record;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface RecordDao {

    Integer insert(Record record);

    Integer delete(Record record);

    List<Record> getAllRecord();

}

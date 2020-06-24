package com.software.fitness.dao;

import com.software.fitness.domain.Record;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface RecordDao {

    Integer insert(Record record);

    Integer delete(Record record);

    Record[] getAllRecord();

}

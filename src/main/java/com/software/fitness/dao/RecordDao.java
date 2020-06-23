package com.software.fitness.dao;

import com.software.fitness.domain.Record;

public interface RecordDao {

    Integer insert(Record record);

    Integer delete(Record record);

}

package com.software.fitness.service;

import com.software.fitness.domain.Record;

public interface RecordService {

    Integer insertRecord(Record record);

    Integer deleteRecord(Record record);

    Record[] getAllRecord();

}

package com.software.fitness.service;

import com.software.fitness.domain.Record;

public interface RecordService {
    Integer insertRecord(Record record);

    void updateRecord(Record record);

    void deleteRecord(Record record);
}

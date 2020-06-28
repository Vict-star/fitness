package com.software.fitness.service;

import com.software.fitness.domain.Record;

import java.util.List;

public interface RecordService {

    Integer insertRecord(Record record);

    Integer deleteRecord(Record record);

    List<Record> getAllRecord();

    Integer staffInsertRecord(Record record);

    Integer memberInsertRecord(Record record);

}

package com.software.fitness.service.Impl;

import com.software.fitness.dao.RecordDao;
import com.software.fitness.domain.Record;
import com.software.fitness.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;

public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordDao recordDao;

    @Override
    public Integer insertRecord(Record record) {
        return recordDao.insert(record);
    }

    @Override
    public Integer deleteRecord(Record record) {
        return recordDao.delete(record);
    }

    @Override
    public Record[] getAllRecord() {
        return recordDao.getAllRecord();
    }
}

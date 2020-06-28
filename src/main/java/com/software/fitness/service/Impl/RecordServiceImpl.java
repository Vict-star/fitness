package com.software.fitness.service.Impl;

import com.software.fitness.dao.RecordDao;
import com.software.fitness.domain.Record;
import com.software.fitness.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public List<Record> getAllRecord() {
        return recordDao.getAllRecord();
    }

    @Override
    public Integer staffInsertRecord(Record record) {
        return recordDao.staffInsert(record);
    }

    @Override
    public Integer memberInsertRecord(Record record) {
        return recordDao.memberInsert(record);
    }
}

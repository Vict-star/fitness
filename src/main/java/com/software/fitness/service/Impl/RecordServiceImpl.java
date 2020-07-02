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
        try {
            return recordDao.insert(record);
        } catch (Exception e) {
            return 0;
        }

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
        try {
            return recordDao.staffInsert(record);
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public Integer memberInsertRecord(Record record) {
        try {
            return recordDao.memberInsert(record);
        } catch (Exception e) {
            return 0;
        }
    }
}

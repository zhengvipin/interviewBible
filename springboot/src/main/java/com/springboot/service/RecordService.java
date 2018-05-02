package com.springboot.service;

import com.springboot.dao.RecordRepository;
import com.springboot.domain.Record;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @classDesc: 记录 业务逻辑处理类
 * @author: Vipin Zheng
 * @createDate: 2018-05-01 23:38:44
 * @version: v1.0
 */
@Service
public class RecordService {
    @Resource
    private RecordRepository recordRepository;

    public Record find() {
        Optional<Record> record = recordRepository.findById(1);
        assert record.isPresent();
        return record.get();
    }

    public void modify(Long page) {
        Optional<Record> record = recordRepository.findById(1);
        assert record.isPresent();
        record.get().setPage(page);
        recordRepository.save(record.get());
    }
}

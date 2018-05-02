package com.springboot.dao;

import com.springboot.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @classDesc: 记录 数据操作接口
 * @author: Vipin Zheng
 * @createDate: 2018-05-01 23:37:24
 * @version: v1.0
 */
@Repository
public interface RecordRepository extends JpaRepository<Record, Integer> {
}

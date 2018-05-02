package com.springboot.dao;

import com.springboot.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @classDesc: 类别 数据操作接口
 * @author: Vipin Zheng
 * @createDate: 2018-05-01 23:37:03
 * @version: v1.0
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}

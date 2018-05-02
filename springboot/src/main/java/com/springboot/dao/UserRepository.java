package com.springboot.dao;

import com.springboot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @classDesc: 用户 数据操作接口
 * @author: Vipin Zheng
 * @createDate: 2018-04-29 15:58:46
 * @version: v1.0
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}



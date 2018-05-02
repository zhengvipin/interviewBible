package com.springboot.dao;

import com.springboot.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @classDesc: 角色 数据操作接口
 * @author: Vipin Zheng
 * @createDate: 2018-04-30 15:57:32
 * @version: v1.0
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}

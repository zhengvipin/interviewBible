package com.springboot.service;

import com.springboot.dao.RoleRepository;
import com.springboot.domain.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @classDesc: 角色 业务逻辑处理类
 * @author: Vipin Zheng
 * @createDate: 2018-05-01 23:38:33
 * @version: v1.0
 */
@Service
@Transactional
public class RoleService {
    @Resource
    private RoleRepository roleRepository;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void save(Role role) {
        roleRepository.save(role);
    }

    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }
}

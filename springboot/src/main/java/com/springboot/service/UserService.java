package com.springboot.service;

import com.springboot.dao.UserRepository;
import com.springboot.domain.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @classDesc: 用户 业务逻辑处理类
 * @author: Vipin Zheng
 * @createDate: 2018-04-30 16:18:20
 * @version: v1.0
 */
@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}

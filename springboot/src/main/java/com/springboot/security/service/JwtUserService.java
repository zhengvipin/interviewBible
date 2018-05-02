package com.springboot.security.service;

import com.springboot.dao.UserRepository;
import com.springboot.domain.User;
import com.springboot.security.util.JwtUserFactory;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @classDesc: 安全用户业务逻辑 处理类
 * @author: Vipin Zheng
 * @createDate: 2018-04-30 15:32:46
 * @version: v1.0
 */
@Service
public class JwtUserService implements UserDetailsService {
    @Resource
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        }
        return JwtUserFactory.create(user);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}

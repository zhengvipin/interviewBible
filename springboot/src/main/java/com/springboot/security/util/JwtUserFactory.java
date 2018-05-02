package com.springboot.security.util;

import com.springboot.domain.Role;
import com.springboot.domain.User;
import com.springboot.security.domain.JwtUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @classDesc: 安全用户工厂类 ——> 用于由user直接生成jwtUser
 * @author: Vipin Zheng
 * @createDate: 2018-04-30 15:27:07
 * @version: v1.0
 */
public class JwtUserFactory {
    // singleton
    private static JwtUser jwtUser;

    private JwtUserFactory() {
    }

    /**
     * 关联安全用户和用户
     *
     * @param user 用户模型
     * @return 安全用户
     */
    public static JwtUser create(User user) {
        if (jwtUser == null) {
            jwtUser = new JwtUser(
                    user.getId(),
                    user.getUsername(), user.getPassword(),
                    user.getEnabled() == 1,
                    user.getLastPasswordResetDate(),
                    user.getLoginDate(),
                    roleToAuthority(user.getRoles())
            );
        }
        return jwtUser;
    }

    /**
     * 关联角色和权限
     *
     * @param roles 角色集合
     * @return 权限集合
     */
    private static List<GrantedAuthority> roleToAuthority(List<Role> roles) {
        return roles.stream()
                .map((e) -> new SimpleGrantedAuthority(e.getName()))
                .collect(Collectors.toList());
    }
}

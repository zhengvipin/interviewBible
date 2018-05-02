package com.springboot.security.controller;

import com.springboot.domain.CustomType;
import com.springboot.domain.User;
import com.springboot.security.domain.JwtUser;
import com.springboot.security.service.JwtUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class JwtUserController {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private JwtUserService jwtUserService;

    @RequestMapping(value = "/login.action", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestParam("username") String username,
                                   @RequestParam("password") String password,
                                   HttpSession session) {
        CustomType customType = new CustomType(200, "登录成功！");
        try {
            // 获得用户名和密码
            UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
            // 认证管理
            Authentication authentication = authenticationManager.authenticate(upToken);
            JwtUser jwtUser = (JwtUser) jwtUserService.loadUserByUsername(username);
            // 更新登录时间
            Optional<User> user = jwtUserService.findById(jwtUser.getId());
            assert user.isPresent();
            user.get().setLoginDate(new Date());
            jwtUserService.save(user.get());
            // 存进 session
            session.setAttribute("user", jwtUser);
        } catch (AuthenticationException e) {
            customType.setCode(400);
            customType.setMessage("账户或密码错误！");
        }
        return ResponseEntity.ok(customType);
    }

    @RequestMapping(value = "/getSession.action", method = RequestMethod.GET)
    public ResponseEntity<?> getSession(HttpSession session) {
        JwtUser user = (JwtUser) session.getAttribute("user");
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/logout.action", method = RequestMethod.GET)
    public ResponseEntity<?> logout(HttpSession session) {
        session.removeAttribute("user");
        session.invalidate();
        return ResponseEntity.ok(new CustomType(200, "OK!"));
    }
}

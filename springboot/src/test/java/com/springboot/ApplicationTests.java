package com.springboot;

import com.springboot.domain.Category;
import com.springboot.domain.Question;
import com.springboot.domain.Role;
import com.springboot.domain.User;
import com.springboot.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private RoleService roleService;

    @Resource
    private UserService userService;

    @Resource
    private CategoryService categoryService;

    @Resource
    private QuestionService questionService;

    @Resource
    private RecordService recordService;

    @Test
    public void addUser() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword(passwordEncoder.encode("admin"));
        user.setEnabled(1);
        user.setLastPasswordResetDate(new Date());
        user.setLoginDate(new Date());
        assert roleService.findById(1L).isPresent();
        user.setRoles(Collections.singletonList(roleService.findById(1L).get()));

        userService.save(user);
    }

    @Test
    public void addRole() {
        Role role1 = new Role();
        role1.setName("ROLE_ADMIN");

        Role role2 = new Role();
        role2.setName("ROLE_OPERATOR");

        roleService.save(role1);
        roleService.save(role2);
    }

    @Test
    public void addCategory() {
        Category category = new Category();
        category.setTitle("Java基础部分");
        //category.setDescription("基础部分的顺序：基本语法，类相关的语法，内部类的语法，继承相关的语法，异常的语法，线程的语法，集合的语法，io 的语法，虚拟机方面的语法。");
        categoryService.save(category);
    }

    @Test
    public void findQuestion() {
        List<Question> questions =
                questionService.findByCondition("", 1L);
        for (Question question : questions) {
            System.out.println(question.getName());
        }
    }

    @Test
    public void findRecord() {
        System.out.println(recordService.find().getPage());
    }
}

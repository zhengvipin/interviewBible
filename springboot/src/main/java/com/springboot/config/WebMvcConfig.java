/*package com.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

*//**
 * @classDesc: 视图配置类
 * @author: Vipin Zheng
 * @createDate: 2018-05-01 23:50:10
 * @version: v1.0
 *//*
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        // 设置首页
        registry.addViewController("/").setViewName("forward:/index.html");
        // 设置优先级
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }
}*/

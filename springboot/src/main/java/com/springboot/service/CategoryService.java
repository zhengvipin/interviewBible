package com.springboot.service;

import com.springboot.dao.CategoryRepository;
import com.springboot.domain.Category;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @classDesc: 分类 业务逻辑处理类
 * @author: Vipin Zheng
 * @createDate: 2018-05-01 23:39:18
 * @version: v1.0
 */
@Service
public class CategoryService {

    @Resource
    private CategoryRepository categoryRepository;

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public void remove(Long id) {
        categoryRepository.deleteById(id);
    }
}

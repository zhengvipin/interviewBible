package com.springboot.service;

import com.springboot.dao.QuestionRepository;
import com.springboot.domain.Question;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @classDesc: 题目 业务逻辑处理类
 * @author: Vipin Zheng
 * @createDate: 2018-05-01 23:38:55
 * @version: v1.0
 */
@Service
public class QuestionService {

    @Resource
    private QuestionRepository questionRepository;

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public List<Question> findByCondition(String name, Long categoryId) {
        return questionRepository.findByCondition(name, categoryId);
    }

    // 根据id查询
    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }

    // 查询记录总数
    public Long count() {
        return questionRepository.count();
    }

    // 新增 | 修改
    public void save(Question question) {
        questionRepository.save(question);
    }

    public void remove(Long id) {
        questionRepository.deleteById(id);
    }
}

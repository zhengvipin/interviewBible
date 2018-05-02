package com.springboot.controller;

import com.springboot.domain.Category;
import com.springboot.domain.Question;
import com.springboot.domain.Record;
import com.springboot.service.CategoryService;
import com.springboot.service.QuestionService;
import com.springboot.service.RecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @classDesc: 题目 控制器类
 * @author: Vipin Zheng
 * @createDate: 2018-05-01 23:33:55
 * @version: v1.0
 */
@RestController
@RequestMapping("/question")
public class QuestionController {

    @Resource
    private QuestionService questionService;

    @Resource
    private RecordService recordService;

    @Resource
    private CategoryService categoryService;

    /**
     * 删除
     *
     * @param id 题目id
     * @return 返回页面的数据
     */
    @GetMapping("/remove.action")
    public ResponseEntity<?> remove(@RequestParam("id") Long id) {
        questionService.remove(id);
        return ResponseEntity.ok(200);
    }

    /**
     * 新增　｜　修改
     *
     * @param categoryId 类别id
     * @param name       题干
     * @param answer     答案
     * @return 返回页面的数据
     */
    @PostMapping("/add.action")
    public ResponseEntity<?> add(@RequestParam("categoryId") Long categoryId,
                                 @RequestParam("name") String name,
                                 @RequestParam("answer") String answer) {
        // 根据id查询类别
        Optional<Category> category = categoryService.findById(categoryId);
        // 封装题目类
        Question question = new Question();
        question.setName(name);
        question.setAnswer(answer);
        assert category.isPresent();
        question.setCategory(category.get());
        // 新增
        questionService.save(question);
        // 返回数据
        return ResponseEntity.ok(200);
    }

    /**
     * 做笔记
     *
     * @param id     题目id
     * @param remark 笔记
     * @return 返回页面的数据
     */
    @PostMapping("/mark.action")
    public ResponseEntity<?> mark(@RequestParam("id") Long id,
                                  @RequestParam("remark") String remark) {
        System.out.println(id);
        System.out.println(remark);
        // 根据id查询题目
        Optional<Question> question = questionService.findById(id);
        assert question.isPresent();
        question.get().setRemark(remark);
        questionService.save(question.get());
        // 返回数据
        return ResponseEntity.ok(200);
    }

    /**
     * 修改
     *
     * @param id     题目id
     * @param answer 答案
     * @return 返回页面的数据
     */
    @PostMapping("/answer.action")
    public ResponseEntity<?> answer(@RequestParam("id") Long id,
                                    @RequestParam("name") String name,
                                    @RequestParam("answer") String answer) {
        // 根据id查询题目
        Optional<Question> question = questionService.findById(id);
        assert question.isPresent();
        question.get().setName(name);
        question.get().setAnswer(answer);
        questionService.save(question.get());
        // 返回数据
        return ResponseEntity.ok(200);
    }

    /**
     * 查询全部
     *
     * @param name       题干
     * @param categoryId 类别id
     * @return 返回页面的数据
     */
    @RequestMapping(value = "/findAll.action", method = RequestMethod.POST)
    public ResponseEntity<?> findAll(@RequestParam("name") String name,
                                     @RequestParam("categoryId") Long categoryId) {
        List<Question> questions = questionService.findByCondition(name, categoryId);
        return ResponseEntity.ok(questions);
    }

    /**
     * 查询学习记录
     *
     * @return 返回页面的数据
     */
    @GetMapping("/record.action")
    public ResponseEntity<?> index() {
        Record record = recordService.find();
        return ResponseEntity.ok(record);
    }

    /**
     * 根据序号查询
     *
     * @param page 题目序号
     * @return 返回页面的数据
     */
    @GetMapping("/findByPage.action")
    public ResponseEntity<?> findById(@RequestParam("page") Long page) {
        // 记录学习进度
        recordService.modify(page);
        // 根据id查找题目
        //Optional<Question> question = questionService.findById(id);
        //assert question.isPresent();
        List<Question> questions = questionService.findAll();
        Map<String, Object> map = new HashMap<>();
        map.put("questions", questions);
        // 题目总数
        Long count = questionService.count();
        map.put("count", count);
        return ResponseEntity.ok(map);
    }
}

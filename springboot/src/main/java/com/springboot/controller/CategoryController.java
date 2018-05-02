package com.springboot.controller;

import com.springboot.domain.Category;
import com.springboot.domain.CustomType;
import com.springboot.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @classDesc: 类别 控制器类
 * @author: Vipin Zheng
 * @createDate: 2018-05-01 23:34:29
 * @version: v1.0
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    /**
     * 查询全部
     * @return 返回页面的数据
     */
    @GetMapping("/findAll.action")
    public ResponseEntity<?> findAll() {
        List<Category> categories = categoryService.findAll();
        return ResponseEntity.ok(categories);
    }

    /**
     * 新增 |　修改
     * @param category　类别封装类
     * @return 返回页面的数据
     */
    @PostMapping("/save.action")
    public ResponseEntity<?> save(Category category) {
        categoryService.save(category);
        return ResponseEntity.ok(200);
    }

    /**
     * 根据id查询
     * @param id 类别id
     * @return 返回页面的数据
     */
    @GetMapping("/findById.action")
    public ResponseEntity<?> findById(@RequestParam("id") Long id) {
        Optional<Category> category = categoryService.findById(id);
        assert category.isPresent();
        return ResponseEntity.ok(category.get());
    }

    /**
     * 删除
     * @param id 类别id
     * @return 返回页面的数据
     */
    @GetMapping("/remove.action")
    public ResponseEntity<?> remove(@RequestParam("id") Long id) {
        CustomType customType = new CustomType(200, "删除成功！");
        try {
            categoryService.remove(id);
        } catch (Exception e) {
            customType.setCode(400);
            customType.setMessage("删除失败！");
        }
        return ResponseEntity.ok(customType);
    }
}

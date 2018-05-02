package com.springboot.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @classDesc: 题目 模型
 * @author: Vipin Zheng
 * @createDate: 2018-04-29 15:28:40
 * @version: v1.0
 */
@Entity(name = "question")
public class Question implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name; // 题干
    @Column
    private String answer; // 参考答案
    @Column
    private String remark; // 笔记
    // 多对一
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category; // 类别

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

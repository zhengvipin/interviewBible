package com.springboot.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @classDesc: 角色 模型
 * @author: Vipin Zheng
 * @createDate: 2018-04-29 22:54:49
 * @version: v1.0
 */
@Entity
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;

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
}

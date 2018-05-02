package com.springboot.domain;

import java.io.Serializable;

/**
 * @classDesc: 自定义返回值模型
 * @author: Vipin Zheng
 * @createDate: 2018-04-30 22:48:13
 * @version: v1.0
 */
public class CustomType implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer code;
    private String message;

    public CustomType(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

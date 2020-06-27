package com.mingm.quicktemplate.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author: panmm
 * @date: 2020/6/27 21:10
 * @description: 用户DTO实体
 */
@Data
public class UserDTO implements Serializable {


    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 6896280449955702839L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 版本号
     */
    private Long version;


    /**
     * 创建时间
     */
    private LocalDateTime created;
}

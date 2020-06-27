package com.mingm.quicktemplate.domain.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: panmm
 * @date: 2020/6/27 21:18
 * @description: 用户VO实体
 */
@Data
public class UserVO implements Serializable {


    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -634281110516343056L;

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

}

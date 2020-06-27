package com.mingm.quicktemplate.domain.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: panmm
 * @date: 2020/6/27 21:52
 * @description: 数据查询DTO实体
 */
@Data
public class UserQueryDTO implements Serializable {


    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 235907715913820724L;

    /**
     * 用户名
     */
    private String username;
}

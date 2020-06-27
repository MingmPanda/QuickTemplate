package com.mingm.quicktemplate.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "用户姓名不能为空！")
    private String username;
}

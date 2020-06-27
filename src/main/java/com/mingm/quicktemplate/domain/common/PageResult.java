package com.mingm.quicktemplate.domain.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: panmm
 * @date: 2020/6/27 22:00
 * @description: 通用分页查询返回实体
 */
@Data
public class PageResult<T> implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -5470824289598297582L;


    /**
     * 当前页号
     */
    private Integer pageNo;

    /**
     * 每页行数
     */
    private Integer pageSize;

    /**
     * 总记录数
     */
    private Long total;

    /**
     * 总页数
     */
    private Long pageNum;

    /**
     * 动态的内容
     */
    private T data;
}

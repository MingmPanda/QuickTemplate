package com.mingm.quicktemplate.domain.common;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author: panmm
 * @date: 2020/6/28 00:03
 * @description: 通用分页查询对象
 */
@Data
public class PageQuery<T> implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 8064292317334939488L;

    /**
     * 当前页
     */
    private Integer pageNo = 1;

    /**
     * 每页条数
     */
    private Integer pageSize = 20;

    /**
     * 动态查询条件
     */
    private T query;
}

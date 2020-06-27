package com.mingm.quicktemplate.domain.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: panmm
 * @date: 2020/6/27 21:31
 * @description: 通用返回结果模型
 */
@Data
public class ResponseResult<T> implements Serializable {


    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -4911588109888767927L;

    /**
     * 是否成功
     */
    private Boolean success;

    /**
     * 编码
     */
    private String code;

    /**
     * 描述信息
     */
    private String message;

    /**
     * 结果
     */
    private T result;

    /**
     * 成功
     * @param result
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> success(T result) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setSuccess(Boolean.TRUE);
        responseResult.setResult(result);

        return responseResult;
    }
}

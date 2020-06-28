package com.mingm.quicktemplate.domain.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.mingm.quicktemplate.util.LocalDateTimeStringConverter;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author: panmm
 * @date: 2020/6/29 02:41
 * @description: Excel导出实体对象
 */
@Data
public class UserExportDTO implements Serializable {


    private static final long serialVersionUID = 4419898356691471875L;

    /**
     * String 类型
     */
    @ExcelProperty(value = "用户名")
    private String username;

    /**
     * Integer 类型
     */
    @ExcelProperty(value = "年龄")
    private Integer age;

    /**
     * Long 类型
     */
    @ExcelProperty(value = "版本号")
    private Long version;

    /**
     * LocalDateTime 类型
     */
    @ExcelProperty(value = "创建时间",
            converter = LocalDateTimeStringConverter.class)
    @DateTimeFormat("yyyy年MM月dd日HH时mm分ss秒SSS毫秒")
    private LocalDateTime created;
}

package com.mingm.quicktemplate.service;

import com.mingm.quicktemplate.domain.dto.UserQueryDTO;

/**
 * @author: panmm
 * @date: 2020/6/29 02:31
 * @description: Excel导出服务接口
 */
public interface ExcelExportService {

    /**
     * 同步导出服务
     * @param query
     * @param filename
     */
    void export(UserQueryDTO query, String filename);
}

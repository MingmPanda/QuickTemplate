package com.mingm.quicktemplate.service;

import com.mingm.quicktemplate.domain.common.PageQuery;
import com.mingm.quicktemplate.domain.common.PageResult;
import com.mingm.quicktemplate.domain.dto.UserDTO;
import com.mingm.quicktemplate.domain.dto.UserQueryDTO;

import java.util.List;

/**
 * @author: panmm
 * @date: 2020/6/28 00:01
 * @description: 用户服务接口
 */
public interface UserService {

    /**
     * 新增
     * @param userDTO
     * @return
     */
    int save(UserDTO userDTO);

    /**
     * 更新
     * @param id
     * @param userDTO
     * @return
     */
    int update(Long id, UserDTO userDTO);

    /**
     * 删除
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 分页查询
     * @param pageQuery
     * @return
     */
    PageResult<List<UserDTO>> query(PageQuery<UserQueryDTO> pageQuery);
}

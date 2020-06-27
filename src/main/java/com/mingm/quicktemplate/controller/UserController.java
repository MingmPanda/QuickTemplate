package com.mingm.quicktemplate.controller;

import com.mingm.quicktemplate.domain.common.PageResult;
import com.mingm.quicktemplate.domain.common.ResponseResult;
import com.mingm.quicktemplate.domain.dto.UserDTO;
import com.mingm.quicktemplate.domain.dto.UserQueryDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author: panmm
 * @date: 2020/6/27 21:27
 * @description: 用户Controller
 */
@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {

    /**
     * 新建用户
     * POST /api/users UserDTO
     * @return
     */
    @PostMapping
    public ResponseResult save(@RequestBody UserDTO userDTO){
        return ResponseResult.success("新增成功");
    }

    /**
     * 更新用户信息
     * PUT /api/user/{id} userDTO userDTO
     * @return
     */
    @PutMapping
    public ResponseResult update(@PathVariable("id") Long id,
                                 @RequestBody UserDTO userDTO) {
        return ResponseResult.success("更新成功");
    }

    /**
     * 删除用户信息
     * DELETE /api/user/{id}
     * @return
     */
    @DeleteMapping
    public ResponseResult delete(@PathVariable("id") Long id) {
        return ResponseResult.success("删除成功");
    }

    /**
     * 查询用户信息
     * GET
     * @return
     */
    @GetMapping
    public ResponseResult<PageResult> query(Integer pageNo,
                                            Integer pageSize,
                                            UserQueryDTO query) {
        return ResponseResult.success(new PageResult());
    }

}

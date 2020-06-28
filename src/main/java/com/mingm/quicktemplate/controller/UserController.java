package com.mingm.quicktemplate.controller;

import com.mingm.quicktemplate.domain.common.PageQuery;
import com.mingm.quicktemplate.domain.common.PageResult;
import com.mingm.quicktemplate.domain.common.ResponseResult;
import com.mingm.quicktemplate.domain.dto.UserDTO;
import com.mingm.quicktemplate.domain.dto.UserQueryDTO;
import com.mingm.quicktemplate.domain.vo.UserVO;
import com.mingm.quicktemplate.exception.ErrorCodeEnum;
import com.mingm.quicktemplate.service.ExcelExportService;
import com.mingm.quicktemplate.service.UserService;
import com.mingm.quicktemplate.util.InsertValidationGroup;
import com.mingm.quicktemplate.util.UpdateValidationGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: panmm
 * @date: 2020/6/27 21:27
 * @description: 用户Controller
 */
@RestController
@RequestMapping("/api/users")
@Validated
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ExcelExportService excelExportService;


    /**
     * 新建用户
     * POST /api/users UserDTO
     * @return
     */
    @CacheEvict(cacheNames = "users-cache", allEntries = true)
    @PostMapping
    public ResponseResult save(
            @Validated(InsertValidationGroup.class)
            @RequestBody UserDTO userDTO){
        int save = userService.save(userDTO);

        if (save == 1) {
            return ResponseResult.success("新增成功！");
        } else {
            return ResponseResult.failure(ErrorCodeEnum.INSERT_FAILURE);
        }
    }

    /**
     * 更新用户信息
     * PUT /api/user/{id} userDTO userDTO
     * @return
     */
    @PutMapping("/{id}")
    public ResponseResult update(
            @NotNull @PathVariable("id") Long id,
            @Validated(UpdateValidationGroup.class) @RequestBody UserDTO userDTO) {
        int update = userService.update(id, userDTO);

        if (update == 1) {
            return ResponseResult.success("更新成功！");
        } else {
            return ResponseResult.failure(ErrorCodeEnum.UPDATE_FAILURE);
        }
    }

    /**
     * 删除用户信息
     * DELETE /api/user/{id}
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseResult delete(
            @NotNull(message = "用户ID不能为空!")
            @PathVariable("id") Long id) {
        int delete = userService.delete(id);

        if (delete == 1) {
            return ResponseResult.success("删除成功！");
        } else {
            return ResponseResult.failure(ErrorCodeEnum.DELETE_FAILURE);
        }
    }

    /**
     * 查询用户信息
     * GET
     * @return
     */
    @Cacheable(cacheNames = "users-cache")
    @GetMapping
    public ResponseResult<PageResult> query(
            @NotNull Integer pageNo,
            @NotNull Integer pageSize,
            @Validated UserQueryDTO query) {

        log.info("未使用缓存！");

        // 构造查询条件
        PageQuery<UserQueryDTO> pageQuery = new PageQuery<>();
        pageQuery.setPageNo(pageNo);
        pageQuery.setPageSize(pageSize);
        pageQuery.setQuery(query);

        // 查询
        PageResult<List<UserDTO>> pageResult =
                userService.query(pageQuery);

        // 实体转换
        List<UserVO> userVOList = Optional
                .ofNullable(pageResult.getData())
                .map(List::stream)
                .orElseGet(Stream::empty)
                .map(userDTO -> {
                    UserVO userVO = new UserVO();

                    BeanUtils.copyProperties(userDTO, userVO);
                    // 对特殊字段做处理
                    userVO.setPassword("******");
                    if (!StringUtils.isEmpty(userDTO.getPhone())) {
                        userVO.setPhone(userDTO.getPhone()
                                .replaceAll("(\\d{3})\\d{4}(\\d{4})"
                                        , "$1****$2"));
                    }

                    return userVO;
                })
                .collect(Collectors.toList());

        // 封装返回结果
        PageResult<List<UserVO>> result = new PageResult<>();
        BeanUtils.copyProperties(pageResult, result);
        result.setData(userVOList);

        return ResponseResult.success(result);
    }

    /**
     * 用户数据导出
     * @param query
     * @param filename
     * @return
     */
    @GetMapping("/export")
    public ResponseResult<Boolean> export(
            @Validated UserQueryDTO query,
            @NotEmpty String filename) {

        log.info("接受到导出请求！filename = {}", filename);

        // 数据导出
//        excelExportService.export(query, filename);
        excelExportService.asyncExport(query, filename);

        return ResponseResult.success(Boolean.TRUE);
    }
}

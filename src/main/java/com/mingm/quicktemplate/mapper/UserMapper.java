package com.mingm.quicktemplate.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mingm.quicktemplate.domain.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: panmm
 * @date: 2020/6/27 22:19
 * @description: UserMapper
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {

    //如果需要自定义方法
}

package com.mingm.quicktemplate.mapper;

import com.mingm.quicktemplate.domain.entity.UserDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

/**
 * @author: panmm
 * @date: 2020/6/27 23:53
 * @description:
 */
@SpringBootTest
@Slf4j
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void find() {
        HashMap<String, Object> param = new HashMap<>();
        param.put("username", "username1");

        List<UserDO> userDOList = userMapper.selectByMap(param);

        log.info("{}", userDOList);
    }
}

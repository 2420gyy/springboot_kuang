package com.chen.service.impl;

import com.chen.mapper.UserMapper;
import com.chen.pojo.User;
import com.chen.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chenchen
 * @date 2021-11-09 12:45
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }
}

package com.chen.service;

import com.chen.pojo.User;

/**
 * @author chenchen
 * @date 2021-11-09 12:43
 */
public interface UserService {

    User queryUserByName(String name);
}

package com.chen.mybatispluswrapper.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.mybatispluswrapper.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @author 24201
 */
public interface IUserService extends IService<User> {

    List<User> findUserByNameAndPwd(User user);

    List<User> findUserByPwd(User user);

    List<User> testMaybe(User user);

    Map<String, Object> testAboutTime(String birth);

    List<User> findUserByLikeName(String inputValue);

    List<User> findUserByUser(User user);
}

package com.chen.vuebootstrap.controller;

import com.chen.vuebootstrap.config.Result;
import com.chen.vuebootstrap.dao.UserMapper;
import com.chen.vuebootstrap.entity.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenchen
 * @date 2022-01-24 8:56
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @CrossOrigin
    @GetMapping("/findAll")
    public Result<?> findAll(){
        System.out.println("======================================");
        List<User> users = userMapper.selectList(null);
        // List<User> users = userMapper.findAll();
        return Result.success(users);
    }

}

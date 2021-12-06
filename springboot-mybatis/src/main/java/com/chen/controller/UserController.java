package com.chen.controller;

import com.chen.pojo.User;
import com.chen.service.UserService;
import com.chen.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/addUser")
    public String addUser(){
        User user = new User(9, "卷卷", "123", 23);
        int i = userService.addUser(user);
        System.out.println("i为：：："+i);
        if(i>0){
            return "插入成功";
        }else return "插入失败";
    }
    @RequestMapping("/selectUserById")
    public String selectUserById(int id){
        User user = userService.selectUserById(id);
        System.out.println("查询成功");
        return user.toString();
    }
    @RequestMapping("/deleteUser")
    public String deleteUser(int id){
        int i = userService.deleteUser(id);
        if(i>0){
            return "删除成功";
        }else return "删除失败";
    }
    @RequestMapping("/updateUserById")
    public String updateUserById(){
        User user4 = new User(4, "小明改", "12", 12);
        userService.updateUserById(user4);
        return "updateUserById";
    }
    @RequestMapping("/queryUserList")
    public String queryUserList(){
        List<User> users = userService.queryUserList();
        return users.toString();
    }
}

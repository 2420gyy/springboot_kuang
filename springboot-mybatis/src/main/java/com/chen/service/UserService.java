package com.chen.service;

import com.chen.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    //增
    int addUser(User user);
    //删
    int deleteUser(int id);
    //改 ?
    int updateUserById(User user);
    //查
    User selectUserById(int id);
    //?
    List<User> queryUserList();
}

package com.chen.mapper;

import com.chen.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
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


    //关联查询-两个
    //嵌套查询-两个


}

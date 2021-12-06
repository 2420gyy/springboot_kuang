package com.chen.mapper;

import com.chen.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chenchen
 * @date 2021-11-09 12:41
 */
@Repository
@Mapper
public interface UserMapper {
    //登录只要用户名
    public abstract User queryUserByName(@Param("name") String name);

    List<User> queryUserList();

    User queryUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);


}

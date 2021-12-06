package com.chen.mybatispluswrapper.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.mybatispluswrapper.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 24201
 */
@Mapper
public interface IUserMapper extends BaseMapper<User> {

    List<User> findUserByPwd(User user);

    List<User> testMaybe(User user);
}

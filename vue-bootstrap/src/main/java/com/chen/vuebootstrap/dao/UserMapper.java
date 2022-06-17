package com.chen.vuebootstrap.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.vuebootstrap.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author chenchen
 * @date 2022-01-24 8:55
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<User> findAll();
}

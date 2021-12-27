package com.chen.springboot_jsp_shiro.dao;

import com.chen.springboot_jsp_shiro.entity.BzUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chenchen
 * @since 2021-12-26
 */
@Mapper
public interface BzUserMapper extends BaseMapper<BzUser> {

    void saveBzUser(BzUser bzUser);

    BzUser findBzUserByName(@Param("username") String username);
}

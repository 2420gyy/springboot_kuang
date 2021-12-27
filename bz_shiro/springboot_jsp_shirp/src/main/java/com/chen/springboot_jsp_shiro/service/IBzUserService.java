package com.chen.springboot_jsp_shiro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.springboot_jsp_shiro.entity.BzUser;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chenchen
 * @since 2021-12-26
 */
public interface IBzUserService extends IService<BzUser> {

    void saveBzUser(BzUser bzUser);

    BzUser findBzUserByName(String username);
}

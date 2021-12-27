package com.chen.springboot_jsp_shiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.springboot_jsp_shiro.dao.BzUserMapper;
import com.chen.springboot_jsp_shiro.entity.BzUser;
import com.chen.springboot_jsp_shiro.service.IBzUserService;
import com.chen.springboot_jsp_shiro.utils.SaltUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenchen
 * @since 2021-12-26
 */
@Service
@Transactional
public class BzUserServiceImpl extends ServiceImpl<BzUserMapper, BzUser> implements IBzUserService {

    @Resource
    private BzUserMapper bzUserMapper;

    @Override
    public void saveBzUser(BzUser bzUser) {
        // 处理业务
        // 明文密码进行MD5 + salt + hash散列
        String salt = SaltUtils.getSalt(8);
        bzUser.setSalt(salt);
        Md5Hash md5Hash = new Md5Hash(bzUser.getPassword(),salt,1024);
        bzUser.setPassword(md5Hash.toHex());
        bzUserMapper.saveBzUser(bzUser);
    }

    @Override
    public BzUser findBzUserByName(String username) {
        return bzUserMapper.findBzUserByName(username);
    }
}

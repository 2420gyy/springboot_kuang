package com.chen.mybatispluswrapper.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.mybatispluswrapper.entity.User;
import com.chen.mybatispluswrapper.mapper.IUserMapper;
import com.chen.mybatispluswrapper.service.IUserService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IUserServiceImpl extends ServiceImpl<IUserMapper, User> implements IUserService {

    @Override
    public List<User> testMaybe(User user) {
        return userMapper.testMaybe(user);
    }

    @Override
    public Map<String, Object> testAboutTime(String birth) {
        Map<String,Object> result = new HashMap<>();
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.apply(StringUtils.isNotBlank(birth),"DATE(birth) = STR_TO_DATE('"+birth+"','%Y-%m-%d')");
        List<User> users = baseMapper.selectList(wrapper);
        result.put("data",users);
        return result;
    }

    @Override
    public List<User> findUserByLikeName(String inputValue) {
        List<User> userList = baseMapper.findUserByLikeName(inputValue);
        return userList;
    }

    @Override
    public List<User> findUserByUser(User user) {
        return baseMapper.findUserByUser(user);
    }

    @Autowired
    private IUserMapper userMapper;


    @Override
    public List<User> findUserByNameAndPwd(User user) {
        LambdaQueryWrapper<User> qw1 = new LambdaQueryWrapper<>();
        //<if test=""> 的wrapper写法
        if(ObjectUtils.isNotEmpty(user)){
            qw1.eq(User::getAge,user.getAge())
                    .eq(user.getPwd()!=null && user.getPwd()!="",User::getPwd,user.getPwd());
        }
        return userMapper.selectList(qw1);
    }

    @Override
    public List<User> findUserByPwd(User user) {
        List<User> userByPwd = userMapper.findUserByPwd(user);
        return userByPwd;
    }
}


package com.lyx.service.impl;

import com.lyx.dao.TUserMapper;
import com.lyx.model.Page;
import com.lyx.model.TUser;
import com.lyx.model.TUserExample;
import com.lyx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户业务层实现类
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private TUserMapper userMapper;



    @Override
    public TUser findUserByNameAndPwd(TUser user) {
        return  userMapper.findUserByUserNameAndPwd(user);
    }

    @Override
    public int addUser(TUser user) {
       return userMapper.insert(user);
    }

    @Override
    public int updateUserById(TUser user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public List<TUser> findUserByUserName(TUser user) {
        TUserExample example = new TUserExample();
        TUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(user.getUserName());
        return userMapper.selectByExample(example);
    }

    @Override
    public TUser findUserById(TUser user) {
        return userMapper.selectByPrimaryKey(user.getId());
    }

    @Override
    public List<TUser> findAllUsers() {
        return userMapper.selectByExample(null);
    }

    @Override
    public List<TUser> findUsersByState(int state) {
        TUserExample example = new TUserExample();
        TUserExample.Criteria criteria = example.createCriteria();
        criteria.andStateEqualTo(state);
        return userMapper.selectByExample(example);
    }

    @Override
    public List<TUser> findAllUsersLimit(Page page) {
        return userMapper.findAllUsersLimit(page);
    }

    @Override
    public long findUserCountByState(Integer state) {
        Long lineCount = null;
        if (state != null){
        TUserExample example = new TUserExample();
        TUserExample.Criteria criteria = example.createCriteria();
        criteria.andStateEqualTo(state);
            lineCount = userMapper.countByExample(example);
        }else {
            lineCount = userMapper.countByExample(null);
        }

        return lineCount;
    }

    @Override
    public List<TUser> findUsersByUserLimit(Page page) {
        return userMapper.findUsersByUserLimit(page);
    }

    @Override
    public long findUserCountByUser(TUser user) {
        TUserExample example = new TUserExample();
        TUserExample.Criteria criteria = example.createCriteria();
        if(user.getId() != null){
            criteria.andIdEqualTo(user.getId());
        }
        if(user.getUserName() != null && !user.getUserName().equals("null")){
            criteria.andUserNameLike("%"+user.getUserName()+"%");
        }
        if(user.getPassword() != null && !user.getPassword().equals("null")){
            criteria.andPasswordLike("%"+user.getPassword()+"%");
        }
        if(user.getTel() != null && !user.getTel().equals("null")){
            criteria.andTelLike("%"+user.getTel()+"%");
        }
        if(user.getAddress() != null && !user.getAddress().equals("null")){
            criteria.andAddressLike("%"+user.getAddress()+"%");
        }
        return userMapper.countByExample(example);
    }

    @Override
    public int deleteUserById(int id) {
        return userMapper.deleteByPrimaryKey(id);
    }


}

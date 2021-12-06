package com.lyx.service;

import com.lyx.model.Page;
import com.lyx.model.TUser;

import java.util.List;

/**
 * 用户业务层接口
 */
public interface UserService {

    /**
     * 根据用户名和密码得到用户
     * @param user
     * @return
     */
    public TUser findUserByNameAndPwd(TUser user);

    /**
     * 添加用户
     * @param user
     */
    public int addUser(TUser user);

    /**
     * 根据id修改用户信息
     * @param user
     * @return
     */
    public int updateUserById(TUser user);

    /**
     * 根据用户名得到用户
     * @param user
     * @return
     */
    public List<TUser> findUserByUserName(TUser user);

    /**
     * 根据用id得到用户
     * @param user
     * @return
     */
    public TUser findUserById(TUser user);

    /**
     * 查询所有数据
     * @return
     */
    public List<TUser> findAllUsers();

    /**
     * 根据状态查询用户
     * @param state
     * @return
     */
    public List<TUser> findUsersByState(int state);

    /**
     * 分页查询货物
     * @param page
     * @return
     */
    public List<TUser> findAllUsersLimit(Page page);

    public long findUserCountByState(Integer state);

    /**
     * 根据条件分页查询
     * @param page
     * @return
     */
    public List<TUser> findUsersByUserLimit(Page page);

    public long findUserCountByUser(TUser user);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    public int deleteUserById(int id);

}

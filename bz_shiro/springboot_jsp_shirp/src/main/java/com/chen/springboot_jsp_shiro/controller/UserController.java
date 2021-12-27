package com.chen.springboot_jsp_shiro.controller;

import com.chen.springboot_jsp_shiro.entity.BzUser;
import com.chen.springboot_jsp_shiro.service.IBzUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author chenchen
 * @date 2021-12-25 20:36
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Resource
    private IBzUserService iBzUserService;

    @RequestMapping("register")
    public String register(BzUser bzUser){
        try{
            iBzUserService.saveBzUser(bzUser);
            return "redirect:/login.jsp";
        }catch (Exception e){
            e.printStackTrace();
            return "redirect:/register.jsp";
        }
    }

    /**
     * 处理身份认证
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("login")
    public String login(String username,String password){
        // 获取主体对象
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(username,password));
            return "redirect:/index.jsp";
        } catch (UnknownAccountException e){
            System.out.println("用户不存在");
            e.printStackTrace();
        } catch (IncorrectCredentialsException e){
            System.out.println("密码错误");
            e.printStackTrace();
        }
        return "redirect:/login.jsp";
    }
    /**
     * 退出登录
     */
    @RequestMapping("logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login.jsp";
    }

}

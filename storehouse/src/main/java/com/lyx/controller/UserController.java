package com.lyx.controller;

import com.alibaba.fastjson.JSONObject;
import com.lyx.model.Page;
import com.lyx.model.TUser;

import com.lyx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
    private Map<String , Object> resMap;

    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }



    @RequestMapping("/login")
    @ResponseBody
    public  Map<String , Object> login(@RequestBody String reqData, HttpServletResponse response, HttpServletRequest request) throws IOException {
        resMap = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName()+"-->"+cookie.getValue());
        }

        String loginRandomStringCode  = (String) request.getSession().getAttribute("loginRandomStringCode");
        JSONObject jsonobject = JSONObject.parseObject(reqData);
        String captcha = jsonobject.getString("captcha");
        if(!captcha.equals(loginRandomStringCode)){
            resMap.put("result","fail");
            resMap.put("failInfo","验证码错误");
            return resMap;
        }
        String isChecked = jsonobject.getString("isChecked");
        jsonobject.remove("captcha");
        jsonobject.remove("isChecked");
        TUser user = JSONObject.toJavaObject(jsonobject,TUser.class);
        TUser u = userService.findUserByNameAndPwd(user);
        if(u!=null ){
            if(u.getState() == 1){
                resMap.put("result","success");
                //新建cookie
                Cookie cookie_name = new Cookie("userName", u.getUserName());
                Cookie cookie_pwd = new Cookie("password", u.getPassword());
                //2 判断是否选中cookie
                if (isChecked .equals( "true")) {
                    // "yes" 勾选了 ==>  设置有效时间为 一周
                    cookie_name.setMaxAge(60*60*24*7);
                    cookie_pwd.setMaxAge(60*60*24*7);
                } else {
                    // null 没勾选 ==>  设置cookie的有效时间为0
                    cookie_name.setMaxAge(0);
                    cookie_pwd.setMaxAge(0);
                }
                cookie_name.setPath("/");
                cookie_pwd.setPath("/");
                //3 将cookie添加到response
                response.addCookie(cookie_name);
                response.addCookie(cookie_pwd);
                request.getSession().setAttribute("USER" , u);
            }else{
                resMap.put("result","fail");
                resMap.put("failInfo","用户未激活，请联系管理员激活！");
            }
        }else {
            resMap.put("result","fail");
            resMap.put("failInfo","用户名或密码错误！");
        }
        return resMap;
    }

    @RequestMapping("/register")
    @ResponseBody
    public  Map<String , Object> register(@RequestBody String reqData, HttpServletResponse response, HttpServletRequest request) throws IOException {
        resMap = new HashMap<>();
        JSONObject jsonobject = JSONObject.parseObject(reqData);
        String registerRandomStringCode  = (String) request.getSession().getAttribute("registerRandomStringCode");
        String captcha = jsonobject.getString("captcha");
        jsonobject.remove("captcha");
        TUser user = JSONObject.toJavaObject(jsonobject,TUser.class);
        System.out.println(user);
        user.setPhoto("img/nullUserPhoto.jpg");
        user.setRole(1);
        user.setState(0);
        int i = userService.addUser(user);
        if(i > 0){
            resMap.put("result","success");
        }else{
            resMap.put("result","fail");
            resMap.put("failInfo","注册失败");
        }
        return resMap;
    }

    @RequestMapping("/updateUserById")
    @ResponseBody
    public Map<String , Object> updateUserById(@RequestBody TUser user, HttpServletRequest request){
        resMap = new HashMap<>();
        int i = userService.updateUserById(user);
        TUser u = userService.findUserById(user);
        if(i > 0){
            resMap.put("result","success");
            resMap.put("user",u);
        }else{
            resMap.put("result","fail");
            resMap.put("failInfo","修改失败");
        }
        return resMap;
    }

    @RequestMapping("/updateUserByIdPersonal")
    @ResponseBody
    public Map<String , Object> updateUserByIdPersonal(@RequestBody TUser user, HttpServletRequest request){
        resMap = new HashMap<>();
        int i = userService.updateUserById(user);
        if(i > 0){
            resMap.put("result","success");
            TUser u = userService.findUserById(user);
            request.getSession().setAttribute("USER" , u);
            resMap.put("user",u);
        }else{
            resMap.put("result","fail");
            resMap.put("failInfo","修改失败");
        }
        return resMap;
    }

    @RequestMapping("/deleteUserById")
    @ResponseBody
    public Map<String , Object> deleteUserById(@RequestBody TUser user, HttpServletRequest request){
        resMap = new HashMap<>();
        int i = userService.deleteUserById(user.getId());
        if(i > 0){
            resMap.put("result","success");
        }else{
            resMap.put("result","fail");
        }
        return resMap;
    }

    @RequestMapping("/findUserByUserName")
    @ResponseBody
    public Map<String , Object> findUserByUserName(@RequestBody TUser user){
        resMap = new HashMap<>();
        List<TUser> users = userService.findUserByUserName(user);
        if(users.size() > 0){
            resMap.put("result","success");
        }else{
            resMap.put("result","fail");
        }
        return resMap;
    }

    @RequestMapping("/findAllUsers")
    @ResponseBody
    public Map<String , Object> findAllUsers(@RequestBody Page page){
        resMap = new HashMap<>();
        Integer state = page.getState();
        System.out.println("state:"+state);
        if(state == -1){
            state = null;
        }
        long lineCount = userService.findUserCountByState(state);
        System.out.println("lineCount:"+lineCount);
        long pageNow = page.getPageNow() == 0 ? 1 : page.getPageNow(); //如果传过来的页码为空，则默认第一页
        Page pageInfo = new Page(lineCount,page.getPageSize(),pageNow,state);
        List<TUser> users = userService.findAllUsersLimit(pageInfo);
        resMap.put("result","success");
        resMap.put("users",users);
        resMap.put("pageInfo",pageInfo);
        return resMap;
    }
    @RequestMapping("/findUsersByPageLimit")
    @ResponseBody
    public Map<String , Object> findUsersByPageLimit(@RequestBody Page page) {
        resMap = new HashMap<>();
        System.out.println(page);
        long lineCount = userService.findUserCountByUser(page.getUser());
        long pageNow = page.getPageNow() == 0 ? 1 : page.getPageNow(); //如果传过来的页码为空，则默认第一页
        Page pageInfo = new Page(lineCount,page.getPageSize(),pageNow,page.getState());
        pageInfo.setUser(page.getUser());
        List<TUser> users = userService.findUsersByUserLimit(pageInfo);
        resMap.put("result","success");
        resMap.put("users",users);
        resMap.put("pageInfo",pageInfo);
        return resMap;
    }
    @RequestMapping("/logout")
    @ResponseBody
    public Map<String , Object> logout(HttpServletRequest request){
       request.getSession().invalidate();
        resMap = new HashMap<>();
        resMap.put("result","success");
        return resMap;
    }

}

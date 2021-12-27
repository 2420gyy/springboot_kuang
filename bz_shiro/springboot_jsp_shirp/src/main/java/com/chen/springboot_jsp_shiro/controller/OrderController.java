package com.chen.springboot_jsp_shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chenchen
 * @date 2021-12-26 16:13
 */
@Controller
@RequestMapping("order")
public class OrderController {

    @RequestMapping("save")
    // @RequiresRoles(value = {"admin","user"}) // 判断角色的 数组形式必须同时具有
    @RequiresPermissions("user:find") // 用来判断权限字符串
    public String save(){
        //代码方式进行授权
        Subject subject = SecurityUtils.getSubject();
        if(subject.hasRole("admin")){
            System.out.println("保存订单");
        }else {
            System.out.println("无权访问");
        }

        // 基于权限字符串

        return "redirect:/index.jsp";
    }

}

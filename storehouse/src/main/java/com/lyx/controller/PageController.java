package com.lyx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageController {
    @RequestMapping("toLogin")
    public String toIndex(){
        return "client/login";
    }
    @RequestMapping("toRegister")
    public String toRegister(){
        return "client/register";
    }
    @RequestMapping("toHome")
    public String toHome(){
        return "client/home";
    }
    @RequestMapping("toPersonalCenter")
    public String toPersonalCenter(){
        return "client/personalCenter";
    }
    @RequestMapping("toGoods")
    public String toGoods(){
        return "client/goods";
    }
    @RequestMapping("toFindGoods")
    public String toFindGoods(){
        return "client/findGoods";
    }

    @RequestMapping("toAdminHome")
    public String toAdminHome(){
        return "admin/adminHome";
    }

    @RequestMapping("toAdminFindUser")
    public String toAdminFindUser(){
        return "admin/adminFindUser";
    }

    @RequestMapping("toAdminFindUserByState")
    public String toAdminFindUserByState(){
        return "admin/adminFindUserByState";
    }

    @RequestMapping("toAdminAllGoods")
    public String toAdminAllUser(){
        return "admin/adminAllGoods";
    }

    @RequestMapping("toAdminAllGoodsByState")
    public String toAdminAllGoodsByState(){
        return "admin/adminAllGoodsByState";
    }

    @RequestMapping("toAdminFindGoods")
    public String toAdminFindGoods(){
        return "admin/adminFindGoods";
    }

    @RequestMapping("toAdminAddGoods")
    public String toAdminAddGoods(){
        return "admin/adminAddGoods";
    }

    @RequestMapping("toAdminGoodsAnalysis")
    public String toAdminGoodsAnalysis(){
        return "admin/adminGoodsAnalysis";
    }

}

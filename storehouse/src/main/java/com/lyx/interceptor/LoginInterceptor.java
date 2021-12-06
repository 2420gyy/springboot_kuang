package com.lyx.interceptor;

import com.lyx.model.TUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 预处理，controller方法执行前处理
     * return false 不放行
     * return true 放行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("LoginInterceptor");
        boolean flag = false;
        //得到session
        HttpSession session = request.getSession();
        //得到请求的内容
        String uri = request.getRequestURI();
        System.out.println("uri:"+uri);
        String reqStr = uri.split("/")[ uri.split("/").length - 1];
        System.out.println("reaStr:"+reqStr);
        String path = request.getServletPath();
        TUser user = (TUser)session.getAttribute("USER");
        System.out.println("flag:"+flag);
        //未登录可进入登录注册界面
        if(reqStr.equals("toLogin")) flag = true;
        if(reqStr.equals("toRegister")) flag = true;
        if (reqStr.equals("login")) flag = true;
        if (reqStr.equals("register")) flag = true;
        if (reqStr.equals("findUserByUserName")) flag = true;
        //未登录
        if(user != null){
            if(user.getRole() == 1 && user.getState() == 1){ //普通员工登录
                System.out.println("user login");
                //页面
                if (reqStr.equals("toHome")) flag = true;
                if (reqStr.equals("toPersonalCenter")) flag = true;
                if (reqStr.equals("toGoods")) flag = true;
                if (reqStr.equals("toFindGoods")) flag = true;
                //功能
                if (reqStr.equals("updateUserById")) flag = true;
                if (reqStr.equals("updateUserByIdPersonal")) flag = true;
                if (reqStr.equals("findUserByUserName")) flag = true;
                if (reqStr.equals("logout")) flag = true;
            }else if(user.getRole() == 0 && user.getState() == 1){ //管理员登录
                System.out.println("admin login");
                flag = true;
            }

        }
        System.out.println("new flag:"+flag);
        if(flag == false){
            response.sendRedirect("error");
        }
        return flag;
    }

    /**
     * 后处理方法：controller方法执行后，页面之前
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("MyInterceptor1执行了====后");
//    }

    /**
     * jsp页面加载完后才会执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("MyInterceptor1执行了====最后");
//    }
}

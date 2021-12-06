package com.lyx.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器
 */
@Component
public class SystemExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //获取到异常对象;
        SystemException se = null;
        if(e instanceof SystemException){
            se = (SystemException)e;
        }else {
            se = new SystemException("系统正在维护。。。");
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg",se.getMassage());
        mv.setViewName("error");
        return mv;
    }
}

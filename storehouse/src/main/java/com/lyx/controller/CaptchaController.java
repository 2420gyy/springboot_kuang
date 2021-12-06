package com.lyx.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyx.utils.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Servlet implementation class CaptchaServlet
 */
@Controller
@RequestMapping("CaptchaController")
public class CaptchaController {

	//登录的验证码
	@RequestMapping("loginRandomStringCode")
	public void loginRandomStringCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String randomStringCode = CaptchaUtil.outputCaptcha(request, response);
		//将获取到的数字放到Session中
		request.getSession().setAttribute("loginRandomStringCode", randomStringCode);
		System.out.println("登录验证码："+randomStringCode);
		
	}
	//注册的验证码
	@RequestMapping("registerRandomStringCode")
	public void registerRandomStringCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String randomStringCode = CaptchaUtil.outputCaptcha(request, response);
		//将获取到的数字放到Session中
		request.getSession().setAttribute("registerRandomStringCode", randomStringCode);
		System.out.println("注册验证码："+randomStringCode);
		
	}
	//修改个人信息的验证码
	public void updateUserRandomStringCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String randomStringCode = CaptchaUtil.outputCaptcha(request, response);
		//将获取到的数字放到Session中
		request.getSession().setAttribute("updateUserRandomStringCode", randomStringCode);
		System.out.println("修改个人信息验证码："+randomStringCode);
		
	}





}

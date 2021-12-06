package com.lyx.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class CaptchaUtil {
	/*
	 * 随机字典
	 */
	 private static final char[] CHARS = {
		'2','3','4','5','6','7','8','9',
		'a','b','c','d','e','f','g','h','i','j','k'
		,'m','n','p',
		'q','r','s','t','u','v','w','x','y','z'
	 };
	 
	 //随机数
	 private static Random random = new Random();
	 
	 //随机获取四位数
	 private static String getRandoString() {
		 StringBuffer buffer = new StringBuffer();
		 for(int i=0;i<4;i++) {
			 buffer.append(CHARS[random.nextInt(CHARS.length)]);
		 }
		 return buffer.toString();
	 }
	 
	 
	 //获取随机颜色
	 private static Color getRandomColor() {
		 int r = random.nextInt(255);
		 int g = random.nextInt(255);
		 int b = random.nextInt(255);
		 return new Color(r,g,b);
	 }
	 
	 
	 //返回某颜色的反色
	 private static Color getReverseColor(Color c) {
		 return new Color(255-c.getRed(), 255-c.getGreen(), 255-c.getBlue());
	 }
	 
	 
	 public static String outputCaptcha(HttpServletRequest request,HttpServletResponse response) throws ServletException ,IOException
	 {
		 //禁止缓存验证码
		 response.setHeader("Pragma", "no-cache");
		 response.setHeader("Cache", "no-cache");
		 response.setHeader("Expires", "0");
		 response.setContentType("image/jpeg");
		 //随机获取四位数字
		 String randomString = getRandoString();
		 //将获取到的数字放到Session中
//		 request.getSession(true).setAttribute("randomStringCode", randomString);
		 
		 //定义验证码的宽高
		 int width = 85;
		 int height = 38;
		 
		 //获取随机颜色
		 Color color = getRandomColor();
		 //得到随机颜色的反色
		 Color revers = getReverseColor(color) ;
		 //绘制验证码宽高，以及类型
		 BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		 //画笔
		 Graphics2D g = bi.createGraphics();
		 
		 //设置验证码中字体的颜色
		 g.setColor(color);
		 //填充验证码的区域
		 g.fillRect(0, 0, width, height);
		 //绘制干扰线条
		 for (int i = 0; i < 15; i++) {
			Random random = new Random();
			int xBegin = random.nextInt(width);
			int yBegin = random.nextInt(height);
			
			int xEnd = random.nextInt(width);
			int yEnd = random.nextInt(height);
			g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,10));
			g.setColor(getRandomColor());
			
			g.drawLine(xBegin, yBegin, xEnd, yBegin);
			
		}
		 StringBuffer sb = new StringBuffer();
		 for(int i=0;i<4;i++) {
			 sb.append(randomString.charAt(i)+" ");
		 }
		//设置验证码中数字的字体，加粗，以及大小
		 g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		 g.drawString(sb.toString(), 12, 30);
		 
		 //画验证码
	//	 g.drawString(randomString, 18, 25);
//		 for (int i = 0 , n=random.nextInt(100); i < n; i++) {
//			g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
//		}
		 //转为JPEG格式
//		 ServletOutputStream out = response.getOutputStream();
//		 JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
//		 encoder.encode(bi);
//		 out.flush();
		 
		 ServletOutputStream out = response.getOutputStream();
		 ImageIO.write(bi, "jpeg", response.getOutputStream());
		 
		 //关闭
		 out.close();
		
		 return randomString;
		 
		 
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	
	
}

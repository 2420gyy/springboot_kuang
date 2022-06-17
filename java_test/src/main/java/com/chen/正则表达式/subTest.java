package com.chen.正则表达式;

/**
 * @author chenchen
 * @date 2022-05-09 22:27
 */
public class subTest {
    public static void main(String[] args) {
        String title = "21893718739-23-2-32.asd";
        String courseId = title.substring(0, title.indexOf("."));
        String userName = title.substring(title.indexOf(".")+1,title.length());
        System.out.println(courseId);
        System.out.println(userName);
    }
}

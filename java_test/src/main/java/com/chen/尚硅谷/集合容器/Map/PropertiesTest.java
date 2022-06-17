package com.chen.尚硅谷.集合容器.Map;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        //放到主目录下面
        FileInputStream fileInputStream = new FileInputStream("jdbc.properties");
        properties.load(fileInputStream);//加载配置文件
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        System.out.println(username+password);


    }
}

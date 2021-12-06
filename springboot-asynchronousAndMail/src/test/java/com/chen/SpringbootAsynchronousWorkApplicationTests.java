package com.chen;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootTest
class SpringbootAsynchronousWorkApplicationTests {


    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Test
    void contextLoads() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setSubject("你好");
        simpleMailMessage.setText("这是一个定时邮件任务");
        simpleMailMessage.setTo("2420191325@qq.com");//发送给
        simpleMailMessage.setFrom("2420191325@qq.com");//接收

        javaMailSender.send(simpleMailMessage);
    }

}

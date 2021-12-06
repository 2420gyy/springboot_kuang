package com.chen;

import com.chen.pojo.User;
import com.chen.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringbootShiro02StartApplicationTests {

    @Resource
    private UserService userService;

    @Test
    void contextLoads() {
        User admin = userService.queryUserByName("admin");
        System.out.println(admin);
    }

}

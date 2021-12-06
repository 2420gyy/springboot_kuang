package com.chen;

import com.chen.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class ConsumerServerApplicationTests {

    @Test
    void contextLoads() {
        Long startTs = System.currentTimeMillis();
        System.out.println(startTs);
        /**
         * 拼接
         */
        StringBuilder newPunishCode = new StringBuilder();
        String punishType="02";
        String punishCode = "2021012201";
        int year = LocalDateTime.now().getYear();
        Integer number = null;
        try {
            number = Integer.parseInt(punishCode.substring(punishCode.length()-4, punishCode.length()));
        } catch (NumberFormatException e) {
            number = 1;
        }finally {
            newPunishCode.append(year).append(punishType).append(String.format("%04d" , number+1));
        }
        System.out.println(newPunishCode.toString());
    }

    @Autowired
    private UserService userService;
    @Test
    void test() {
        //获取售票数据
        userService.getTicket();
    }

}

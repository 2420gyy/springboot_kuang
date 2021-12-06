package com.chen.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    //秒 分 时 日 月 周几
    //具体操作查找文档
    @Scheduled(cron = "0 17 23 * * ?")
    public void hello(){
        System.out.println("hello，被执行了");
    }

}

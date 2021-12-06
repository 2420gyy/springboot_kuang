package com.chen.service;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    //在消费者中使用dubbo订阅远程服务：使用dubbo提供的@Reference注解
    @Reference
    private TicketService ticketService;

    //想拿到provide的票
    public void getTicket(){
        String ticket = ticketService.getTicket();
        System.out.println("从注册中心拿到:"+ticket);
    }

}

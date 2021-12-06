package com.chen.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

//zookeeper服务注册与发现
@Service//可以被扫描到，项目一启动可以注册到注册中心/服务发布出去
@Component
public class TicketServiceImpl implements TicketService{
    @Override
    public String getTicket() {
        return "电影票数据";
    }
}

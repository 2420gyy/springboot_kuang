package com.chen.work有时间整理回顾下.设计模式.a工厂模式;

public class PeoSender implements Sender{
    @Override
    public void send() {
        System.out.println("现在换成一个人来送快件");
    }
}

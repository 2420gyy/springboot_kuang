package com.chen.work有时间整理回顾下.设计模式.a工厂模式;

public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("this is mailsender!");
    }
}
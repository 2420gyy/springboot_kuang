package com.chen.work有时间整理回顾下.设计模式.a工厂模式;

public class SendFactory {
 
    public Sender produce(String type) {
        if ("mail".equals(type)) {
            return new MailSender();
        } else if ("sms".equals(type)) {
            return new SmsSender();
        } else if ("peo".equals(type)) {
            return new PeoSender();
        } else {
            System.out.println("请输入正确的类型!");
            return null;
        }
    }

    public static Sender produceMail(){
        return new MailSender();
    }

    public static Sender produceSms(){
        return new SmsSender();
    }
    // 返回PeoSender和其实现接口Sender的区别
    /*
    接口的实现类都可以向上转型为接口

    当我们返回一个接口类型时，其实就是意味着，以后你完全可以把其返回值赋给一个实现了此接口的实现类的实例。
    这样编写的好处是，此接口的实现类的实例在运行时可以任意灵活指定，而不需要修改接口函数的代码。

    方法应返回基类的引用？？？

     */

    public static PeoSender peoSender(){
        return new PeoSender();
    }

}
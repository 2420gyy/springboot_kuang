package com.chen.work有时间整理回顾下.设计模式.a工厂模式;

public class FactoryTest {

    /*
    总体来说，工厂模式适合：凡是出现了大量的产品需要创建，并且具有共同的接口时，可以通过工厂方法模式进行创建。
    在以上的三种模式中，第一种如果传入的字符串有误，不能正确创建对象，
    第三种相对于第二种，不需要实例化工厂类，所以，大多数情况下，我们会选用第三种——静态工厂方法模式。
     */
 
    public static void main(String[] args) {
        SendFactory sendFactory = new SendFactory();
//        Sender sender = sendFactory.produce("sms");
        Sender sender = sendFactory.produceSms();

        Sender peo = sendFactory.produce("peo");
        PeoSender peoSender = new PeoSender();
        peoSender = (PeoSender)peo; // 向下转型！！！

        sender.send();

        // 静态工厂模式
        SendFactory.produceSms().send();

        SendFactory.peoSender().send();

    }
}

/*
优点：
    一个调用者想创建一个对象，只要知道其名称就可以了。
    扩展性高，如果想增加一个产品，只要扩展一个工厂类就可以。
    屏蔽产品的具体实现，调用者只关心产品的接口。

缺点：
    每次增加一个产品时，都需要增加一个具体类和对象实现工厂，使得系统中类的个数增加，
    在一定程度上增加了系统的复杂度，同时也增加了系统具体类的依赖。这并不是什么好事。
 */
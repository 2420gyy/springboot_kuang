package com.chen.work有时间整理回顾下.设计模式.x责任链模式;

public class HandlerClient {
    public static void main(String[] args) {

        FirstPassHandler firstPassHandler = new FirstPassHandler();//第一关
        SecondPassHandler secondPassHandler = new SecondPassHandler();//第二关
        ThirdPassHandler thirdPassHandler = new ThirdPassHandler();//第三关

        firstPassHandler.setSecondPassHandler(secondPassHandler);//第一关的下一关是第二关
        secondPassHandler.setThirdPassHandler(thirdPassHandler);//第二关的下一关是第三关

        //说明：因为第三关是最后一关，因此没有下一关
        //开始调用第一关 每一个关卡是否进入下一关卡 在每个关卡中判断
        firstPassHandler.handler();

        // 每个关卡中都有下一关的成员变量并且是不一样的，形成链很不方便
        // 既然每个关卡中都有下一关的成员变量并且是不一样的，那么我们可以在关卡上抽象出一个父类或者接口，
        // 然后每个具体的关卡去继承或者实现
    }
}
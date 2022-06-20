package com.chen.work有时间整理回顾下.设计模式.x责任链模式;

public class ThirdPassHandler {

    //本关卡游戏得分
    private int play(){
        return 95;
    }

    /**
     * 这是最后一关，因此没有下一关
     */
    public int handler(){
        System.out.println("第三关-->ThirdPassHandler，这是最后一关啦");
        return play();
    }
}
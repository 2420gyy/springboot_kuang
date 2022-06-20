package com.chen.work有时间整理回顾下.设计模式.x责任链模式.xsuper;

public class ThirdPassHandler extends AbstractHandler{

    private int play(){
        return 95;
    }

    public int handler(){
        System.out.println("第三关-->ThirdPassHandler");
        int score = play();
        if(score >= 95){
            //分数>=95 并且存在下一关才进入下一关
            if(this.next != null){
                return this.next.handler();
            }
        }
        return score;
    }
}
package com.chen.work有时间整理回顾下.设计模式.x责任链模式.xsuper;

public class SecondPassHandler extends AbstractHandler{

    private int play(){
        return 90;
    }

    public int handler(){
        System.out.println("第二关-->SecondPassHandler");

        int score = play();
        if(score >= 90){
            //分数>=90 并且存在下一关才进入下一关
            if(this.next != null){
                return this.next.handler();
            }
        }

        return score;
    }
}
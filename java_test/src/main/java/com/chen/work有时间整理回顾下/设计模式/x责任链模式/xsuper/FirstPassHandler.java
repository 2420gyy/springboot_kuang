package com.chen.work有时间整理回顾下.设计模式.x责任链模式.xsuper;

public class FirstPassHandler extends AbstractHandler{

    private int play(){
        return 80;
    }

    @Override
    public int handler() {

        System.out.println("第一关-->FirstPassHandler");
        int score = play();
        if(score>=80){
            // 满足条件，进入下一关 这里next进行了赋值，是一个链式的情况
            if(this.next!=null){
                return this.next.handler();
            }
        }
        return score;
    }

}

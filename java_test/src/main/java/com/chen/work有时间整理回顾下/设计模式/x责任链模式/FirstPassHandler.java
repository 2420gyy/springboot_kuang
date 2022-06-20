package com.chen.work有时间整理回顾下.设计模式.x责任链模式;

public class FirstPassHandler {
    /**
     * 第一关的下一关是 第二关
     */
    private SecondPassHandler secondPassHandler;

    public void setSecondPassHandler(SecondPassHandler secondPassHandler) {
        this.secondPassHandler = secondPassHandler;
    }

    //本关卡游戏得分
    private int play(){
        return 80;
    }

    public int handler(){
        System.out.println("第一关-->FirstPassHandler");
        if(play() >= 80){
            //分数>=80 并且存在下一关才进入下一关
            if(this.secondPassHandler != null){
                return this.secondPassHandler.handler();
            }
        }

        return 80;
    }


}

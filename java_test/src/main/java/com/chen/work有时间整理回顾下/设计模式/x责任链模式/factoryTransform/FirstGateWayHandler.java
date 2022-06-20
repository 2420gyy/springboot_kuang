package com.chen.work有时间整理回顾下.设计模式.x责任链模式.factoryTransform;

public class FirstGateWayHandler extends GatewayHandler{

    private int play(){
        return 80;
    }

    @Override
    public int service() {
        System.out.println("第一关-->FirstGateWayHandler");
        int score = play();
        if(score>=80){
            if(this.next!=null){
                return this.next.service();
            }
        }
        return score;
    }
}

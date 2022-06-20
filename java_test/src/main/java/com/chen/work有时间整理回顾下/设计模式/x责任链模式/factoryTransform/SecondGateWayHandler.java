package com.chen.work有时间整理回顾下.设计模式.x责任链模式.factoryTransform;

public class SecondGateWayHandler extends GatewayHandler{

    private int play(){
        return 90;
    }

    @Override
    public int service() {
        System.out.println("第二关-->SecondGateWayHandler");
        int score = play();
        if(score>=90){
            if(this.next!=null){
                return this.next.service();
            }
        }
        return score;
    }
}

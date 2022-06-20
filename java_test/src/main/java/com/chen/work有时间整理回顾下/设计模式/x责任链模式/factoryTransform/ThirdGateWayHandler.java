package com.chen.work有时间整理回顾下.设计模式.x责任链模式.factoryTransform;

public class ThirdGateWayHandler extends GatewayHandler{

    private int play(){
        return 95;
    }

    @Override
    public int service() {
        System.out.println("第三关-->ThirdGateWayHandler");
        int score = play();
        if(score>=95){
            if(this.next!=null){
                return this.next.service();
            }
        }
        return score;
    }
}

package com.chen.work有时间整理回顾下.设计模式.x责任链模式.factoryTransform;

public abstract class GatewayHandler {

    protected GatewayHandler next;

    public void setNext(GatewayHandler next) {
        this.next = next;
    }

    public abstract int service();


}

package com.chen.work有时间整理回顾下.设计模式.x责任链模式.factoryTransform;

public class GatewayClient {
    public static void main(String[] args) {
        GatewayHandler firstGatewayHandler = GatewayHandlerEnumFactory.getFirstGatewayHandler();
        firstGatewayHandler.service();
    }
}
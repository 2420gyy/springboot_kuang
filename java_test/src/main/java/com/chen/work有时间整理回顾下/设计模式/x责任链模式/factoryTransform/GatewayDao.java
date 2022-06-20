package com.chen.work有时间整理回顾下.设计模式.x责任链模式.factoryTransform;

public interface GatewayDao {

    /**
     * 根据 handlerId 获取配置项
     * @param handlerId
     * @return
     */
    GatewayEntity getGatewayEntity(Integer handlerId);

    /**
     * 获取第一个处理者
     * @return
     */
    GatewayEntity getFirstGatewayEntity();
}
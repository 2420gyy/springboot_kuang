package com.chen.work有时间整理回顾下.设计模式.x责任链模式.factoryTransform;

/**
 * 这里是枚举的方式，也可以使用配置文件的方式
 */
public enum GatewayEnum {
    // handlerId, 拦截者名称，全限定类名，preHandlerId，nextHandlerId
    API_HANDLER(new GatewayEntity(1, "满足80分的", "com.设计模式.x责任链模式.factoryTransform.FirstGateWayHandler", null, 2)),
    BLACKLIST_HANDLER(new GatewayEntity(2, "满足90分的", "com.设计模式.x责任链模式.factoryTransform.SecondGateWayHandler", 1, 3)),
    SESSION_HANDLER(new GatewayEntity(3, "满足95分的", "com.设计模式.x责任链模式.factoryTransform.ThirdGateWayHandler", 2, null)),
    ;

    GatewayEntity gatewayEntity;

    public GatewayEntity getGatewayEntity() {
        return gatewayEntity;
    }

    GatewayEnum(GatewayEntity gatewayEntity) {
        this.gatewayEntity = gatewayEntity;
    }
}
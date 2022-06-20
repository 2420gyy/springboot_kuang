package com.chen.work有时间整理回顾下.设计模式.x责任链模式.factoryTransform;

public class GatewayEntity {

    private Integer handlerId;

    private String name;

    private String conference;

    private Integer preHandlerId;

    private Integer nextHandlerId;

    public GatewayEntity() {
    }

    public GatewayEntity(Integer handlerId, String name, String conference, Integer preHandlerId, Integer nextHandlerId) {
        this.handlerId = handlerId;
        this.name = name;
        this.conference = conference;
        this.preHandlerId = preHandlerId;
        this.nextHandlerId = nextHandlerId;
    }

    public Integer getHandlerId() {
        return handlerId;
    }

    public void setHandlerId(Integer handlerId) {
        this.handlerId = handlerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public Integer getPreHandlerId() {
        return preHandlerId;
    }

    public void setPreHandlerId(Integer preHandlerId) {
        this.preHandlerId = preHandlerId;
    }

    public Integer getNextHandlerId() {
        return nextHandlerId;
    }

    public void setNextHandlerId(Integer nextHandlerId) {
        this.nextHandlerId = nextHandlerId;
    }
}
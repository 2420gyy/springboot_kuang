package com.chen.work有时间整理回顾下.设计模式.x责任链模式.xsuper;

public abstract class AbstractHandler {

    /**
     * 下一关用当前抽象类来接收
     */
    protected AbstractHandler next;

    /**
     * 主函数调用这个方法，进行赋值
     * @param next
     */
    public void setNext(AbstractHandler next){
        this.next = next;
    }
    // 根据具体业务添加方法

    public abstract int handler();

}

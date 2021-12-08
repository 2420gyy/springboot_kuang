package com.chen.尚硅谷.泛型;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenchen
 * @date 2021-12-05 15:21
 */
public class Order<T> {

    String orderName;
    int orderId;
    // 类的内部结构就可以使用类的泛型
    T orderT;

    public Order() {
        // 必须加强转，编译可通过,编译和运行状态，大坑
        // T[] arr = (T[]) new Object();
    }

    public Order(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }
    public T getOrderT(){
        return this.orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }
    // 明确什么叫泛型方法
    // 泛型参数与类的泛型参数没有关系，所属的类或接口是不是泛型的都没有关系
    // 确定泛型参数为E
    public <E> List<E> copyFromArrayToList(E[] arr){
        List<E> list = new ArrayList<>();
        for (E e : arr){
            list.add(e);
        }
        return list;
    }

}

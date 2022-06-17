package com.chen.集合容器测试;

public class SimpleList<T>{

    private Object[] elementData;

    private int size;

    private final int DEFAULT_CAPACITY = 10; // 默认大小

    private final Object[] EMPTY_ELEMENTDATA = {}; // 空数组

    public int size() {
        // 在初始化的时候为0，add的时候会自己增加，这个地方只需要返回size
        return size;
    }

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    public SimpleList(){
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    // 有参构造函数，注意判断
    public SimpleList(int capacity){
        if(capacity > 0){
            this.elementData = new Object[capacity];
        }else if (capacity == 0){
            this.elementData = EMPTY_ELEMENTDATA;
        }else {
            throw new IllegalArgumentException("非法的长度 ："+capacity);
        }

    }

    // 这个想不到。。。
    public boolean isEmpty() {    
        return size == 0;
    }    

    public boolean add(T e) {
        // ???
        // size++ / length??? 理解这两个的区别
        // 成员变量 /
        // trimToSize
        elementData[elementData.length+1] = e;
        return true;

    }

    public boolean remove(Object o) {
        for (int i = 0; i < elementData.length; i++) {
            if(elementData[i].equals(o)){
                for (int j = i; j < elementData.length; j++) {
                    elementData[j] = elementData[j+1];
                }
                return true;
            }
        }
        return false;

    }

    public T get(int index) {

        return null;

    }

}
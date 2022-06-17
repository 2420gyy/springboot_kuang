package com.chen.work有时间整理回顾下.拷贝;

public class Address  implements Cloneable{
    private String add;

    public Address() {
    }

    public Address(String add) {
        this.add = add;
    }

    public String getAdd() {
        return add; 
    } 
 
    public void setAdd(String add) { 
        this.add = add; 
    }

    // 浅拷贝？
    // @Override
    // protected Address clone() throws CloneNotSupportedException {
    //     Address address = null;
    //     address = (Address) super.clone();
    //     return address;
    // }

    // 默认实现
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Address{" +
                "add='" + add + '\'' +
                '}';
    }
}
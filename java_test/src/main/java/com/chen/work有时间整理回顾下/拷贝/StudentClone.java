package com.chen.work有时间整理回顾下.拷贝;

public class StudentClone implements Cloneable{

    private String name;

    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // @Override
    // protected StudentClone clone() throws CloneNotSupportedException {
    //     StudentClone studentClone = null;
    //     studentClone = (StudentClone) super.clone();
    //     // 深复制
    //     studentClone.address = (Address) address.clone();
    //     return studentClone;
    // }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "StudentClone{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}

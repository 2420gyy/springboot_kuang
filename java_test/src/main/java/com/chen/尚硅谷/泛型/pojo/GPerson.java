package com.chen.尚硅谷.泛型.pojo;

/**
 * @author chenchen
 * @date 2021-12-07 14:18
 */
public class GPerson {

    public GPerson() {
        System.out.println("GPerson的无参构造");
    }

    int a = 2;
    static String aa = "ss";

    public void GP(){
        System.out.println("GPerson的方法");
    }
    public void GP2(){
        System.out.println("GPerson的第二个方法");
    }
    private void GPSs(){
        System.out.println("GPerson的私有方法");
    }

}

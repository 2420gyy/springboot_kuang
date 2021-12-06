package com.chen.interfaceTest;

/**
 * @author chenchen
 * @date 2021-12-04 11:46
 */
public class F {

    int fInt = 3;

    public void addAll(){
        System.out.println("父类的addAll方法");
    }

    public void addAllFather1(){
        System.out.println("父类public的1方法");
    }
    private void addAllFather2(){
        System.out.println("父类public的2方法");
    }

}

package com.chen.work有时间整理回顾下.EffectiveJava.Singleton;

/**
 * 枚举实现单例模式
 * 
 * @author Administrator
 *
 */
public enum Singleton_6 {

    instance;

    /**
     * (1)自由序列化。
     *
     * (2)保证只有一个实例。
     *
     * (3)线程安全。
     */
    private Singleton_6() {
        System.out.println("调用构造方法");
    }

    public Singleton_6 getInstance() {
        return instance;
    }

    public void otherMethods(){
        System.out.println("Something");
    }

    public static void main(String[] args) {
        System.out.println(Singleton_6.instance.getInstance());
        // 推荐这种写法？
        Singleton_6.instance.otherMethods();
    }
}
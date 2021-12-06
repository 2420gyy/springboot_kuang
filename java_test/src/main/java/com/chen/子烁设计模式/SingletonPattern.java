package com.chen.子烁设计模式;

/**
 * @author chenchen
 * @date 2021-12-02 17:45
 */

/**
 *
 * 确保一个类只有一个实例，而且自行实例化（一个类只有一个实例）并向整个系统提供整个实例
 * 构造方法必须是priivate / 类变量，即static修饰 / 提供一个静态的方法
 *
 * 访问一个对象消耗较多资源时，eg:访问IO，数据库资源，作为工具类使用
 *
 * 实例化时机: 饿汉式 / 懒汉式
 *  一开始提供(类加载时实现) / 需要时才给
 *  注意加锁！！！
 *  双重检查锁
 *
 *  多个实例的情况： 分布式系统 / jvm 多个类加载器同时加载这个类，产生多个实例
 *
 */
public class SingletonPattern {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance1();
        Singleton instance2 = Singleton.getInstance2();
        System.out.println(instance1.equals(instance2));
    }
}
class Singleton{
    private static Singleton HungrySingleton = new Singleton();
    private static Singleton LazySingleton;
    private volatile static Singleton singleton;

    // 私有的构造方法
    private  Singleton() {}

    // 饿汉式
    public static Singleton getInstance1(){
        return HungrySingleton;
    }

    // 懒汉式
    public synchronized static Singleton getInstance2(){
        if(LazySingleton == null){
            LazySingleton = new Singleton();
        }
        return LazySingleton;
    }

    // 双重检查锁
    public static Singleton getInstance3(){
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){
                    singleton = new Singleton(); // 1.分配内存 2.初始化对象 3.指向刚才分配的地址  2 3 可能颠倒
                }
            }
        }
        return singleton;
    }

}

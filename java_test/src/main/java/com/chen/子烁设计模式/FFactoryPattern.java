package com.chen.子烁设计模式;

/**
 * @author chenchen
 * @date 2021-12-05 19:06
 */

/**
 * 工厂模式
 */
public class FFactoryPattern {

    public static void main(String[] args) {
    }

}

//0.产品接口
interface Productable<T>{
    FProduct<T> fPrduct();
}
// 1. 工厂抽象类
interface FFactory<E> extends Productable<E> {
    // 改成T类型看报错
    FProduct<E> fPrduct();
}
// // 2.产品抽象类
interface FProduct<E>{
    void print();
}
//
// // 3.产品类A
// class FProductA{
//
// }
// // 4.产品类B
// class FProductB{
//
// }
//
// 5.生产产品A的工厂
// class FFactoryA implements FFactory{
//
//     public Productable<T> productable(){
//         return new Por();
//     }
//
//     private class Por() extends Productable<T> {
//
//         @Override
//         public FProduct<T> fPrduct() {
//             return null;
//         }
//     }
//
//     // 没有写多重的实现类，放这不用
//     @Override
//     public FProduct fPrduct() {
//         return null;
//     }
// }
//
// // 6.生产产品B的工厂
// class FFactoryB extends FFactory{
//
// }
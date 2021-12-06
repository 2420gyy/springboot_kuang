package com.chen.子烁设计模式;

/**
 * @author chenchen
 * @date 2021-12-02 20:02
 */

/**
 *  静态工厂方法模式 根据参数的不同返回不同的实例；
 *  简单工厂模式专门定义一个类来负责其他类的实例，被创建的实例通常都具有共同的父类
 *  eg：DateFormat
 *
 *  优点：实现对象的创建和使用分离
 *  缺点：不够灵活，新增一个产品就要修改工厂类
 *
 */
public class SimpleFactoryPattern {

    public static Product createProduct(String type){
        if ("A".equals(type)){
            return new ProductA();
        }else {
            return new ProductB();
        }
    }

    public static void main(String[] args) {
        Product product = SimpleFactoryPattern.createProduct("A");
        product.print();
    }
}
abstract class Product{
      // 必须声明为抽象的，要么就需要写方法体
      abstract void print();
}

class ProductA extends Product{

    @Override
    public void print() {
        System.out.println("a");
    }
}

class ProductB extends Product{

    @Override
    public void print() {
        System.out.println("b");
    }
}

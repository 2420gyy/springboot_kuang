package com.chen.GOF;

/**
 * @author chenchen
 * @date 2021-11-24 10:52
 */

/**
 * 汽车在转动时，并不关注“是什么品牌的轮胎“，只关注”是轮胎“，想怎么转就怎么转
 *
 * 从这个例子我们可以看出，面向接口编程的特性：
 *
 * 客户无须知道他们使用对象的特定类型，只须对象有客户所期望的接口
 *
 * 客户使用汽车转动轮胎时，无须知道轮胎的特定类型（品牌，对应的子类），只要轮胎有客户所期望的接口（roll）就行了
 *
 * 客户无须知道他们使用的对象是用什么类来实现的，他们只须知道定义接口的抽象类
 *
 * 客户使用Car的roll方法调用轮胎对应的方法时，不需要知道这个轮胎实例是用什么子类实现的，他只需要知道定义转动方法的抽象类（JAVA中的interface）的内容就行了

 */
public class GOFTest2 {
    public static void main(String[] args) {
        Car car = new Car();
        Tire tire = new Michelin();
        car.roll(tire);
    }
}
class Car {
    public void roll(Tire tire) {
        tire.roll();
    }
}
// class Car {
//     public void roll(Bridgestone tire) {
//         tire.roll();
//     }
// }

// 接口Tire定义了“转动”这个接口，但把实现延迟到了子类中
interface Tire {
    void roll();
}

class Bridgestone implements Tire {
    @Override
    public void roll() {
        System.out.print("Bridgestone is rolling.");
    }
}
class Michelin implements Tire {
    @Override
    public void roll() {
        System.out.print("Michelin is rolling");
    }
}

// class Bridgestone {
//     public void roll() {
//         System.out.print("Bridgestone is rolling.");
//     }
// }
//
// class Michelin {
//     public void roll() {
//         System.out.print("Michelin is rolling");
//     }
// }

package com.chen.GOF;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenchen
 * @date 2022-01-10 8:30
 */
public class InstanceofTest {
//https://www.cnblogs.com/ysocean/p/8486500.html
    /**
     * instanceof 严格来说是Java中的一个双目运算符，用来测试一个对象是否为一个类的实例(确定对象是否属于给定类型)
     * boolean result = obj instanceof Class
     *
     * 其中 obj 为一个对象，Class 表示一个类或者一个接口，
     * 当 obj 为 Class 的对象，或者是其直接或间接子类，或者是其接口的实现类，结果result 都返回 true，否则返回false。
     *
     * null 是可以成为任意引用类型的特殊符号
     * 如果 obj 为 null，那么将返回 false。
     *
     */
    @Test
    public void test(){
        ArrayList<Object> list = new ArrayList<>();
        // obj 是 class接口的实现类
        if(list instanceof List){
            System.out.println("真");
        }
        System.out.println("======");
        iPerson p1 = new iPerson();
        Man m1 = new Man();
        iPerson p2 = new Man();

        // obj 是 class的直接子类
        if(m1 instanceof iPerson){
            System.out.println("真");
        }
        System.out.println("======");
        System.out.println(p1 instanceof Man);//false
        // 父类的对象指向子类的实例
        System.out.println(p2 instanceof Man);//true

        // String s = (String)p1;// 编译的时候就报错
        // 将 'p1' 转换为 'List' 会为任意非 null 值生成 'ClassCastException'
        List l = (List)p1;
        /**
         * 伪代码
         * boolean result;
         * if (obj == null) {
         *   result = false;
         * } else {
         *   try {
         *       T temp = (T) obj; // checkcast
         *       result = true;
         *   } catch (ClassCastException e) {
         *       result = false;
         *   }
         * }
         * // 如果 obj 不为 null 并且 (T) obj 不抛 ClassCastException 异常则该表达式值为 true ，否则值为 false
         */


    }

    public class iPerson {

    }
    public class Man extends iPerson {

    }

    @Test
    public void test2(){
        sss s1 = new sss();
        // 如果 T 是接口类型，那么 T 必须是由数组实现的接口之一；
        List<Object> list = new ArrayList<>();
        if(s1 instanceof ss){
            System.out.println("true");
        }
        System.out.println("======");
    }
    class sss extends ArrayList{

    }
    interface ss extends List{

    }

}

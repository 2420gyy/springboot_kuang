package com.chen.尚硅谷.java8新特性.微信博客;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @author chenchen
 * @date 2022-01-25 15:11
 */
public class ConsumerTest {
    // 定义一个方法，方法的参数传递一个Consumer<String>接口，传递一个字符串变量
    public static void consumer(String str, Consumer<String> con) {
        // 使用消费类型接口对象，消费传递的字符串值
        con.accept(str);
    }

    // 定义一个方法，方法的参数传递一个字符串和两个Consumer接口，Consumer接口的泛型指定为字符串
    public static void consumers(String str, Consumer<String> con1,Consumer<String> con2) {
       /* con1.accept(str);
        con2.accept(str);*/
        // andThen 连续消费  default Consumer<String> andThen
        // 先执行左边的Consumer--con1的动作，andThen--->再次执行Consumer--con2动作
        con1.andThen(con2).accept(str);
        // 规则 con1连接con2 ，先执行con1消费数据，在执行con2消费数据
    }

    public  static void main(String[] args) {
        // 来创建消费方法consumer,Consumer<String>接口是一个函数式接口类型，所以可以使用Lambda表达式
        consumer("abcdefg", name -> {
            // 把里面的abcdefg字符串改为大写输出 消费的规则自定义
            String str = name.toUpperCase();
            String s = new StringBuffer(str).reverse().toString();
            System.out.println(s);// GFEDCBA
        });

        // 如果一个方法的参数和返回值全都是Consumer类型
        // 由于consumers方法的参数Consumer接口是一个函数式接口，可以使用Lambda表达式
        consumers("Java31-中国最棒-都是业界大佬", (name1)->{
            // 消费规则
            // 截取传入的字符串
            String sub = name1.substring(0, 6);
            System.out.println(sub);
        }, (name2) -> {
            // 定义消费的规则 分成字符串数组展示
            String[] strs = name2.split("-");
            System.out.println(Arrays.toString(strs));// {“Java31","中国最棒","都是业界大佬"}
        });


        /**
         * 定义一个字符串数组，存储每一个人的信息如：“张三，20，郑州市”,存储5个人的信息
         * 使用Consumer接口，按照指定的格式进行打印输出：姓名:张三;年龄:20;地址:郑州市
         * 要求将打印姓名的动作作为第一个Consumer接口的规则
         * 将打印年龄的动作作为第二个Consumer接口的规则
         * 将打印地址的动作作为第三个Consumer接口的规则。
         * 最终将三个Consumer接口按照规定的顺序拼接输出出来。
         */
        // 定义一个字符串数组
        String[] arr = {"李四,20,南阳市", "张三,20,郑州市", "小孙,20,开封市", "小丽,20,信阳市", "小赵,20,洛阳市"};
        // 调用consumers方法，由于Consumer接口是一个函数式接口，所以可以使用Lambda
        consumers(arr, one -> System.out.print("姓名:" + one.split(",")[0] + ";"),
                two -> System.out.print("年龄:" + two.split(",")[1] + ";"),
                three -> System.out.println("地址:" + three.split(",")[2]));
    }

    public static void consumers(String[] arr, Consumer<String> con1, Consumer<String> con2, Consumer<String> con3) {
        // 操作arr数组当中的每一个元素
        for (String str : arr) {
            con1.andThen(con2).andThen(con3).accept(str);// 定义了消费的先后的顺序
        }
    }

}

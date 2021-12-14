package com.chen.尚硅谷.反射;

/**
 * @author chenchen
 * @date 2021-12-12 21:27
 */

import com.chen.尚硅谷.反射.pojo.RPerson;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 *
 */
public class NewInstanceTest {

    @Test
    @SneakyThrows
    public void test1(){
        Class<RPerson> clazz = RPerson.class;
        RPerson o1 = clazz.getDeclaredConstructor().newInstance();
        System.out.println(o1);
        // 调用此方法，创建对应的运行时类的对象
        // new 反射 反序列化 clone
         /*
        newInstance():调用此方法，创建对应的运行时类的对象。内部调用了运行时类的空参的构造器。

        要想此方法正常的创建运行时类的对象，要求：
        1.运行时类必须提供空参的构造器
        2.空参的构造器的访问权限得够。通常，设置为public。

        在javabean中要求提供一个public的空参构造器。原因：
        1.便于通过反射，创建运行时类的对象
        2.便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器

         */
        RPerson obj = clazz.newInstance(); //jdk1.8后被弃用？？？
        Class<?> o2 = Class.forName("com.chen.尚硅谷.反射.pojo.RPerson");
        System.out.println(obj);
        System.out.println(o2.newInstance());

    }
    @Test
    public void test2(){
        int i = new Random().nextInt(3);
        String classPath ="";
        switch (i){
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.lang.Object"; // 没有空参构造器
                break;
            case 2:
                classPath = "com.chen.尚硅谷.反射.pojo.RPerson";
                break;
        }
        try {
            Object instance = getInstance(classPath);
            System.out.println(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 创建一个指定类的对象
    public Object getInstance(String classPath) throws Exception{
        Class aClass = Class.forName(classPath);
        return aClass.newInstance();

    }

}

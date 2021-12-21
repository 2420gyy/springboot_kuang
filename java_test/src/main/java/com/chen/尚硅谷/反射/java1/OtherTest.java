package com.chen.尚硅谷.反射.java1;


import com.chen.尚硅谷.反射.pojo.Person;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * @author shkstart
 * @create 2019 下午 4:19
 */
public class OtherTest {

    /*
    获取构造器结构

     */
    @Test
    public void test1(){

        Class clazz = Person.class;
        //getConstructors():获取当前运行时类中声明为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for(Constructor c : constructors){
            System.out.println(c);
        }

        System.out.println();
        //getDeclaredConstructors():获取当前运行时类中声明的所有的构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for(Constructor c : declaredConstructors){
            System.out.println(c);
        }

    }

    /*
    获取运行时类的父类

     */
    @Test
    public void test2(){
        Class clazz = Person.class;

        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);
    }

    /*
    获取运行时类的带泛型的父类

     */
    @Test
    public void test3(){
        Class clazz = Person.class;

        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }

    /*
    获取运行时类的带泛型的父类的泛型


    代码：逻辑性代码  vs 功能性代码
     */
    @Test
    public void test4(){
        Class clazz = Person.class;

        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        //获取泛型类型
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
//        System.out.println(actualTypeArguments[0].getTypeName());
        // class实现了Type接口 向下转型
        System.out.println(((Class)actualTypeArguments[0]).getName());
    }

    /*
    获取运行时类实现的接口
     */
    @Test
    public void test5(){
        Class clazz = Person.class;

        Class[] interfaces = clazz.getInterfaces();
        for(Class c : interfaces){
            System.out.println(c);
        }

        System.out.println();
        //获取运行时类的父类实现的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for(Class c : interfaces1){
            System.out.println(c);
        }

    }
    /*
        获取运行时类所在的包

     */
    @Test
    public void test6(){
        Class clazz = Person.class;

        Package pack = clazz.getPackage();
        System.out.println(pack);
    }

    /*
        获取运行时类声明的注解

     */
    @Test
    public void test7(){
        Class clazz = Person.class;

        Annotation[] annotations = clazz.getAnnotations();
        for(Annotation annos : annotations){
            System.out.println(annos);
        }
    }
    // 获取注解的属性
    @SneakyThrows
    @Test
    public void test8(){
        Class clazz = Person.class;
        // Annotation annotation1 = clazz.getAnnotation(MyAnnotation.class);
        for (Annotation annotation : clazz.getAnnotations()) {
            MyAnnotation annotation1 = (MyAnnotation) annotation;
            System.out.println(annotation1.value());
            System.out.println(annotation);
        }

    }
    @Test
    public void test9(){
        int num = 6;
        String code = "5426";
        String format = String.format("%06d", Integer.parseInt(code));
        System.out.println(format);
        ArrayList<String> a = new ArrayList<>();
        a.add("a");
        a.add("b");
        a.add("c");
        System.out.println(a);
        a.remove(0);
        a.remove(0);
        System.out.println(a);
    }

}

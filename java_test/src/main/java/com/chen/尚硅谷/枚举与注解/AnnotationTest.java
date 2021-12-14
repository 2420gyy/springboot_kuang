package com.chen.尚硅谷.枚举与注解;

/**
 * @author chenchen
 * @date 2021-12-08 9:50
 */

import org.junit.jupiter.api.Test;

import java.lang.annotation.*;
import java.util.Date;

/**
 * 1. Annotation 其实就是代码里的特殊标记, 这些标记可以在编译, 类加载, 运行时被读取, 并执行相应的处理。
 * 2. @Override 编译时，校验方法是否是重写的
 * 3. @Deprecated 过时的，不推荐使用，这个最好必须推荐一个新的api
 *
 * 二: 跟踪代码依赖性，实现替代配置文件功能
 *
 *  1. 自定义注解
 *  参照SuppressWarnings定义
 *  Annotation的成员变量是以无参数方法的形式来声明的
 *  可以指定默认值
 *
 *  没有成员定义的 Annotation 称为标记; 包含成员变量的 Annotation 称为元数据 Annotation
 *
 *  4.jdk提供的元注解
 *      修饰其他注解的注解
 *      元数据: 对现有数据的修饰的一个数据
 *   @Retention 指定注解的声明周期 包含RetentionPolicy成员变量
 *      RetentionPolicy.SOURCE:在源文件中有效（即源文件保留），编译器直接丢弃这种策略的注释（.class文件不会有）
 *      RetentionPolicy.CLASS:在class文件中有效（即class保留） ， 当运行 Java 程序时, JVM不会保留注解。（不会加载到内存） 这是默认值
 *      RetentionPolicy.RUNTIME:在运行时有效（即运行时保留），当运行 Java 程序时, JVM 会保留注释。程序可以通过反射获取该注释。
 *   @Target 用于修饰 Annotation 定义, 用于指定被修饰的 Annotation 能用于修饰哪些程序元素
 *   @Documented 用于指定被该元 Annotation 修饰的 Annotation 类将被javadoc 工具提取成文档
 *      定义为Documented的注解必须设置Retention值为RUNTIME。
 *   @Inherited 被它修饰的 Annotation 将具有继承性。如果某个类使用了被Inherited 修饰的 Annotation, 则其子类将自动具有该注解。
 *
 *  5.通过反射获取注解信息
 *
 *  三：jdk8新特性 可重复注解，类型注解
 *      可重复注解 （jdk1.8之前为注解创建数组）之后，声明@Repeatable(xx.class)，保证声明周期一样，注解也要一致
 *
 *      类型注解
 *          TYPE_PARAMETER Type parameter declaration
 *              class Generic<@MyAnnotation T>
 *          TYPE_USE Use of a type
 *              ArrayList<@MyAnnotation String>
 *              int i = （@MyAnnotation int）10L;
 *       通过注解拿到值，看想做什么
 *
 *
 */
public class AnnotationTest {
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        int a = 10;

        new AnnotationTest().print();

        Date date = new Date(2021,12,8); // Sun Jan 08 00:00:00 CST 3922
        System.out.println(date);
        System.out.println("=======通过反射获取注解信息========");

    }
    @Test
    public void testGetAnnotation(){
        Class annotationTestClass = AUser.class;
        Annotation[] annotations = annotationTestClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }

    @Deprecated
    public void print(){
        System.out.println("过时的方法");
    }
    @Override
    public String toString() {
        return "重写的toString方法()";
    }

    @MyAnnotation(value = "hello2")
    class A{

    }

    // @MyAnnotations({@MyAnnotation(value = "hi"),@MyAnnotation(value = "hello1")})
    @MyAnnotation(value = "hi1")
    @MyAnnotation(value = "hi2")
    class AUser{

    }
}


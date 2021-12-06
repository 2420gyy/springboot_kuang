package com.chen;

import com.chen.pojo.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author chenchen
 * @date 2021-11-23 11:31
 */
public class reflectTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Student> studentClass1 = Student.class;
        Class<Student> studentClass2 = Student.class;
        System.out.println("类名.class  "+studentClass1);
        System.out.println(studentClass1 == studentClass2);
        Student student = new Student();
        Class<? extends Student> studentClass3 = student.getClass();
        System.out.println("对象名.getClass()  "+studentClass1);
        System.out.println(studentClass1 == studentClass3);
        //使用Class类中的静态方法forName(String className)
        try {
            Class<?> aClass = Class.forName("com.chen.pojo.Student");
            System.out.println("Class.forName()形式 "+aClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("===========反射方法==============");
        //反射方法
        Class<?> c1 = Class.forName("com.chen.pojo.Student");

        for (Constructor<?> constructor : c1.getConstructors()) {
            System.out.println(constructor);
        }
        System.out.println("===");
        for (Constructor<?> declaredConstructor : c1.getDeclaredConstructors()) {
            System.out.println(declaredConstructor);
        }
        System.out.println("===");
        Constructor<?> constructor = c1.getConstructor();
        Object o = constructor.newInstance();
        System.out.println(o);
        System.out.println("===");
        // TODO
        Constructor constructor1 = Student.class.getConstructor(String.class);
        Student chen = (Student) constructor1.newInstance("data");
        System.out.println(chen.getName());


    }
}

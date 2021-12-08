package com.chen.尚硅谷.泛型;

import com.chen.尚硅谷.泛型.pojo.GPerson;
import com.chen.尚硅谷.泛型.pojo.GStudent;
import org.junit.jupiter.api.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author chenchen
 * @date 2021-12-07 12:44
 */
public class GenericAboutExtendsTest {
    /**
     *  1.泛型在继承方面的体现
     *  类A是类B的父类，但是G<A>和G<B>不具备父子关系（并列）
     */
    @Test
    public void test1(){
        Object obj = null;
        String str = null;
        obj = str;

        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;

        List<Object> list1 = null;
        List<String> list2 = null;

        // list1 = list2;

    }

    @Test
    public void test2(){
        List<String> list1 = null;
        ArrayList<String> list2 = null;
        AbstractList<String> list3 = null;

    }

    /**
     *  2.泛型通配符 ?
     *  类A是类B的父类，G<A>和G<B>是没有关系的，二者共同的父类是：G<?>
     *      List<?>是所有List<String>和List<Object>等各种泛型的父类
     */
    @Test
    public void test3(){
        List<String> list1 = null;
        List<Object> list2 = null;

        List<?> list = null;

        list = list1;
        list = list2;
        // print(list1);
        // print(list2);

        List<String> list3 = new ArrayList<>();
        list3.add("AA1");
        list3.add("AA2");
        list3.add("AA3");
        list = list3;
        // 添加:不能向内部添加数据
        // 除了添加null外
        // list.add("BB");
        list.add(null);
        print(list);

        // 获取:允许读
        System.out.println(list.get(0));
    }
    /**
     3.有限制的通配符
     ? extends Person 上限，必须继承或实现接口 小于等于
     ? super Person 指定类型不能小于操作类 大于等于
     */
    @Test
    public void test4(){
        List<? extends GPerson> list1 = null; // (--,Person]
        List<? super GPerson> list2 = null; // [Person,++)

        List<GStudent> list3 = new ArrayList<>();
        List<GPerson> list4 = new ArrayList<>();
        List<Object> list5 = new ArrayList<>();

        list1 = list3;
        list1 = list4;
        // list1 = list5;

        // list2 = list3;
        list2 = list4;
        list2 = list5;

        // 读取数据
        list1 = list3;
        GPerson gPerson = list1.get(0);
        Object obj = list1.get(0);

        list2 = list4;
        Object object = list2.get(0);

        // 写入数据
        // list1.add(new GStudent());

        list2.add(new GPerson());
        list2.add(new GStudent()); // 多态的形式
        // list2.add(new Object());
    }
    @Test
    public void test5(){
        List<? extends GPerson> egPeople = null;
        List<? super GPerson> sgPeople = null;

        List<GStudent> gStudents = new ArrayList<>();
        List<GPerson> gPeoples = new ArrayList<>();
        List<Object> objects = new ArrayList<>();
        // 分别赋值给egPeople和sgPeople
        // extends 能接受 <= GPerson的类型(类或接口实现类)
        egPeople = gStudents;
        egPeople = gPeoples;
        // egPeople = objects;

        // super 赋值能接受 >= GPerson的类型
        // sgPeople = gStudents;
        sgPeople = gPeoples;
        sgPeople = objects;

        // 读取数据都可以 读取时必须用最大的接收（多态）
        // 因为父类不能赋值给子类

        // 写入数据:
        // 子类可以赋给父类，父类不能赋给子类
        // egPeople.add(new GStudent()); // 这个地方，? extends GPerson ，? 可能比GStudent小,违反父类不能赋给子类


        // ? super GPerson （ >= ）   子类可以赋给父类！！！
        // sgPeople.add(new Object());
        sgPeople.add(new GPerson());
        GPerson gp = new GStudent(); // 多态 注意:因为GStudent继承了GPerson，每次创建时都要访问父类的无参构造
        gp.GP();
        sgPeople.add(new GStudent());

        // 泛型练习 : P574




    }


    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }
}

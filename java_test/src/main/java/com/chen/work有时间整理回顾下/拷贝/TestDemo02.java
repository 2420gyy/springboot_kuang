package com.chen.work有时间整理回顾下.拷贝;


/**
 * 由于 Object 本身没有实现 Cloneable 接口，所以不重写 clone 方法并且进行调用的话会发生 CloneNotSupportedException 异常。
 *
 * 基本变量：赋值不改变原来的指
 * 引用变量：正常的引用赋值，都指向内存堆中同一个对象，一个变了原对象也会变
 *         clone方法返回与当前对象的一个副本对象。可以通过操作副本对象而不影响当前对象。
 *         浅克隆： stu.clone() 指向同一片内存地址
 *         深克隆： 所有的类都要重写clone方法，返回一个新的对象，互不影响
 */

public class TestDemo02 {
    public static void main(String[] args) throws CloneNotSupportedException {

        StudentClone studentClone1 = new StudentClone();
        studentClone1.setName("张三");

        StudentClone studentClone2 = studentClone1;

        System.out.println(studentClone1);
        System.out.println(studentClone2);

        // 将1改了,2也会变，应为2的引用指向1对象; stu1和stu2指向内存堆中同一个对象
        studentClone1.setName("张三改");

        System.out.println(studentClone2);

        System.out.println("========================================");

        StudentClone stu1 = new StudentClone();
        stu1.setName("使用clone");
        stu1.setAddress(new Address("XXX"));
        System.out.println(stu1);

        // 注意，这个地方address不能为null
        StudentClone stu2 = (StudentClone)stu1.clone();
        System.out.println(stu2);
        stu1.setName("使用clone改");
        // 此时不再受影响 浅复制(Shallow Copy)
        System.out.println(stu2);
        System.out.println(stu1);

        System.out.println("========================================");

        Address addr = new Address();
        addr.setAdd("杭州市");
        StudentClone stu11 = new StudentClone();
        stu11.setName("123");
        stu11.setAddress(addr);

        StudentClone stu22 = (StudentClone)stu11.clone();

        System.out.println("学生1:" + stu11.getName() + ",地址:" + stu11.getAddress().getAdd());
        System.out.println("学生2:" + stu22.getName() + ",地址:" + stu22.getAddress().getAdd());

//        stu11.setAddress(new Address("地址测试"));
        addr.setAdd("地址测试2");

        System.out.println("学生1:" + stu11.getName() + ",地址:" + stu11.getAddress().getAdd());
        System.out.println("学生2:" + stu22.getName() + ",地址:" + stu22.getAddress().getAdd());




    }
}

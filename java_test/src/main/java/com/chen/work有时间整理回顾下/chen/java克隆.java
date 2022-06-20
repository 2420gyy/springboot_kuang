package com.chen.work有时间整理回顾下.chen;

/**
 * 深克隆 针对类使用的引用数据类型在修改的时候也会被修改
 *       所以要在引用数据类型中重写clone方法
 */
public class java克隆 {
    public static void main(String[] args) throws CloneNotSupportedException {

        Student student = new Student();
        student.setAge(12);
        student.setName("zhangsan");
        Student student2 = (Student) student.clone();
        System.out.println(student2);
        System.out.println("-----------------");
        student.setName("李四");
        System.out.println(student2);
        System.out.println("-----------------");

    }
}
//克隆的对象必须实现Cloneable这个接口，而且需要重写clone方法


class Student implements Cloneable
{
    private int age;
    //定义为private说明这个成员变量只能被被当前类中访问，如果外部需要获得，那么就只能通过getAge方法进行获取
    private String name;
    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

        @Override
    public Student clone()
    {
        Student stu = null;
        try {
            stu = (Student) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return stu;
    }


}
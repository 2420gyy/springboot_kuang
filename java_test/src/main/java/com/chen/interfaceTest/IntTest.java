package com.chen.interfaceTest;

/**
 * @author chenchen
 * @date 2021-11-26 19:41
 */
// 这个有先后顺序
public class IntTest extends F implements A{

    @Override
    public void addAll() {
        System.out.println("重写父类的方法");
    }
    public void addAllChild(){
        System.out.println("子类的特有方法");
    }

    public static void main(String[] args) {
        IntTest intTest = new IntTest();
        intTest.addAll();
        System.out.println(intTest.add(1, 2));

        // 多态，父类的引用，指向子类对象
        F intTest1 = new IntTest();
        IntTest intTest2 = new IntTest();

        //
        int fInt = intTest1.fInt;

        intTest1.addAll();
        intTest2.addAll();

        //调用》》》
        // 因为子类是对父类的改进和扩充。定义一个父类类型的引用指向一个子类的对象既可以使用子类强大的功能，
        // 又可以抽取父类的共性。 但是父类类型的引用可以调用父类中定义的所有属性和方法，
        // 而对于子类中定义而父类中没有的方法，父类引用是无法调用的；

        // 当父类中的一个方法只有在父类中定义而在子类中没有被重写的情况下，才可以被父类类型的引用调用；
        // 对于父类中定义的方法，如果子类中重写了该方法，那么父类类型的引用将会调用子类中的这个方法，这就是动态连接。
        System.out.println("F intTest1 = new IntTest()能调用的>>>");
        intTest1.addAllFather1();
        System.out.println("IntTest intTest2 = new IntTest()能调用的>>>");
        intTest2.addAllFather1();
        intTest2.addAllChild();

        // java中“向上转型”是自动的。但是“向下转型”却不是自动的
        IntTest in = (IntTest) intTest1;
        in.addAll();


    }

    @Override
    public int add(int a, int b) {
        return a+b;
    }
}

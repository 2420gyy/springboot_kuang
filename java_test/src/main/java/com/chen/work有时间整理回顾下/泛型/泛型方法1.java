package com.chen.work有时间整理回顾下.泛型;

public class 泛型方法1 {

    /**
     *
     * @param inputArray 传入泛型的参数
     * @param <E> 泛型的类型
     * @return T 返回值为T类型
     * 说明：
     *   1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
     *   2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     *   3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     *   4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E等形式的参数常用于表示泛型。
     *
     *  List<? extends Number> 通配符泛型值接受Number及其下层子类类型
     *  类型通配符下限通过形如 List<? super Number> 来定义，
     *  表示类型只能接受 Number 及其上层父类类型，如 Object 类型的实例。
     *  一个操作数字的方法可能只希望接受Number或者Number子类的实例。这就是有界类型参数的目的。
     * 要声明一个有界的类型参数，首先列出类型参数的名称，后跟extends关键字，最后紧跟它的上界。
     */
    // 泛型方法 printArray
    public static <E> void printArray( E[] inputArray )
    {
        // 输出数组元素
        for ( E element : inputArray ){
            System.out.printf( "%s ", element );
        }
        System.out.println();
    }

    public static void main( String args[] )
    {
        // 创建不同类型数组： Integer, Double 和 Character
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

        System.out.println( "整型数组元素为:" );
        printArray( intArray  ); // 传递一个整型数组

        System.out.println( "\n双精度型数组元素为:" );
        printArray( doubleArray ); // 传递一个双精度型数组

        System.out.println( "\n字符型数组元素为:" );
        printArray( charArray ); // 传递一个字符型数组

        myGenerics("sss");
        myGenerics(123);


    }

    private static  <T> void myGenerics(T num){
        System.out.println(num);
        System.out.println(String.class.isInstance(num));
    }

}

package com.chen.尚硅谷.异常.博客测试;

import jdk.internal.instrumentation.Logger;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenchen
 * @date 2022-01-18 11:20
 */
public class Test01 {
    /**
     * 解决办法就是封装异常，可以把异常的阅读者分为两类：开发人员和用户。
     * 开发人员查找问题，需要打印出堆栈信息，而用户则需要了解具体的业务原因，比如文件太大、不能同时编写文件等，代码如下：
     */
    /**
     * 提高系统的友好性
     */
    @Test
    public void test1(){

        try {
            InputStream is = new FileInputStream("无效文件.txt");
        } catch (FileNotFoundException e) {
            // 方便开发人员和维护人员而设置的异常信息
            e.printStackTrace();
            // throw new ; 抛出自定义异常
        }
        System.out.println("======");
    }

    /**
     * 提高系统的可维护性
     * 方便后台维护人员查看异常信息
     */
    @Test
    public void test2(){
        Logger log = null;
        try{
            //doSomething
            InputStream is = new FileInputStream("无效文件.txt");
        }catch(FileNotFoundException e){
            log.info("文件未找到，使用默认配置文件....");
            e.printStackTrace();
        }catch(SecurityException e1){
            log.info(" 无权访问，可能原因是......");
            e1.printStackTrace();
        }
        System.out.println("======");
    }
    @Test
    public void test3() throws MyException{
        // 解决Java异常机制自身的缺陷
        // Java中的异常一次只能抛出一个
        List<Throwable> list = new ArrayList<Throwable>();
        // 第一个逻辑片段
        try {
            // Do Something
        } catch (Exception e) {
            list.add(e);
        }
        // 第二个逻辑片段
        try {
            // Do Something
        } catch (Exception e) {
            list.add(e);
        }
        // 检查是否有必要抛出异常
        if (list.size() > 0) {
            throw new MyException(list);
        }

        System.out.println("======");
    }
    // 自定义异常类
    class MyException extends Exception{


        // 容纳所有的异常
        private List<Throwable> causes = new ArrayList<Throwable>();

        // 构造函数，传递一个异常列表
        public MyException(List<? extends Throwable> _causes) {
            causes.addAll(_causes);
        }

        // 读取所有的异常
        public List<Throwable> getExceptions() {
            return causes;
        }
    }
    //

    public class IOException extends Exception {

        public IOException() {
            super();
        }
        //定义异常原因
        public IOException(String message) {
            super(message);
        }
        //定义异常原因，并携带原始异常
        public IOException(String message, Throwable cause) {
            super(message, cause);
        }
        //保留原始异常信息
        public IOException(Throwable cause) {
            super(cause);
        }
    }
    // 捕捉到Exception异常，然后把它转化为IOException异常并抛出(此种方式也叫作异常转译)，
    // 调用者获得该异常后再调用getCause方法即可获得Exception的异常信息，如此即可方便地查找到产生异常的基本信息，便于解决问题。
    /*
    try{
            //doSomething
        }catch(Exception e){
            throw new IOException(e);
        }
     */

    // TODO 受检异常尽可能转化为非受检异常

    // 不要在finally块中处理返回值
    // 方法在栈中执行，遵循先进后出的原则
    @Test
    public void test4(){



        System.out.println("======");
    }
    // 注意：不要在finally代码块中出现return语句。
    // 不要在构造函数中抛出异常

    /*
    Error类及其子类表示的是错误，它是不需要程序员处理也不能处理的异常，比如VirtualMachineError虚拟机错误，ThreadDeath线程僵死等。
    RunTimeException类及其子类表示的是非受检异常，是系统可能会抛出的异常，程序员可以去处理，也可以不处理，最经典的就是NullPointException空指针异常和IndexOutOfBoundsException越界异常。
    Exception类及其子类(不包含非受检异常)，表示的是受检异常，这是程序员必须处理的异常，不处理则程序不能通过编译，比如IOException表示的是I/O异常，SQLException表示的数据库访问异常
     */

    static class Foo {
        public static boolean method() {
            // 取得当前栈信息
            StackTraceElement[] sts = new Throwable().getStackTrace();
            // 检查是否是methodA方法调用
            for (StackTraceElement st : sts) {
                if (st.getMethodName().equals("methodA")) {
                    return true;
                }
            }
            return false;
        }
    }
    //调用者
    class Invoker{
        //该方法打印出true
        public void methodA(){
            System.out.println(Foo.method());
        }
        //该方法打印出false
        public void methodB(){
            System.out.println(Foo.method());
        }
    }
    @Test
    public void test5(){
        Invoker invoker = new Invoker();
        invoker.methodA();

        System.out.println("======");
    }
    /*
    在出现异常时(或主动声明一个Throwable对象时)，
    JVM会通过fillInStackTrace方法记录下栈帧信息，然后生成一个Throwable对象，
    这样我们就可以知道类间的调用顺序，方法名称及当前行号等了。
     */


    /*
    异常只能用在非正常的情况下，不能成为正常情况下的主逻辑
    使用if先做判断，减少异常出现的概率，
     */
}

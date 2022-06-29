package com.chen.尚硅谷.IO;

/**
 * @author chenchen
 * @date 2022-01-10 16:41
 */

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * File 类的一个对象，代表一个文件或一个文件目录
 * file类都是对文件或者文件目录的创建，删除，以及文件属性的设置和获取；
 * 没有设计到文件的内容
 * 后续file类经常作为参数传递到流的构造器中
 */
public class FileTest {

    @Test
    public void test1(){
        // 路径问题
        // 相对路径
        // 绝对路径
        // 分隔符的问题 File.separator
        // 以下都是内存层面的对象
        // 构造器1
        File file = new File("hello.txt");// 相对于module
        File file1 = new File("C:\\Users\\24201\\Desktop\\vue课程设计\\springboot_狂神\\java_test\\hello1.txt");

        System.out.println(file);
        System.out.println(file1);

        // 构造器2
        File file2 = new File("C:\\Users\\24201\\Desktop\\vue课程设计\\springboot_狂神", "java_test");
        System.out.println(file2);

        // 构造器3
        File file3 = new File(file2,"hi.txt");
        System.out.println(file3);
    }
    @Test
    public void test2(){
        File file1 = new File("hello.txt");
        File file2 = new File("C:\\Users\\24201\\Desktop\\vue课程设计\\springboot_狂神\\java_test\\hello1.txt");
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.getPath());
        System.out.println(file1.length());
        //
        // long l=System.currentTimeMillis();
        long l=file1.lastModified();
        Date date=new Date(l);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        System.out.println(sdf.format(date));
        System.out.println(file1.lastModified());

        System.out.println("======");
    }
    @Test
    public void test3(){
        File file = new File("C:\\Users\\24201\\Desktop\\vue课程设计\\springboot_狂神\\java_test");
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("===========");
        for (File listFile : file.listFiles()) {
            System.out.println(listFile);
        }
    }
    @Test
    public void test4(){
        // 重命名 重新命名的文件不能存在
        File file1 = new File("C:\\Users\\24201\\Desktop\\vue课程设计\\springboot_狂神\\java_test\\ss.txt");
        File file2 = new File("hello2.txt");
        boolean b = file1.renameTo(file2);
        System.out.println(b);
        System.out.println("======");
    }
    @Test
    public void test5(){
        // File类的判断问题
        File file = new File("hello.txt");
        System.out.println(file.isFile());
        System.out.println(file.isDirectory()); // false

        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isHidden()); // false

        System.out.println("======");
    }
    @Test
    public void test6() throws IOException {
        // File类的创建/删除功能
        File file = new File("hi.txt");
        if(!file.exists()){
            file.createNewFile();
        }else {
            System.out.println(file.getPath());
            System.out.println(file.getAbsolutePath());
            System.out.println(file.getAbsoluteFile());
            file.delete();
        }
        System.out.println("======");
    }
    @Test
    public void test7(){
        // 文件目录的创建
        // mkdir();
        // mkdirs(); 可以一次创建多层目录
        System.out.println("======");
    }
}

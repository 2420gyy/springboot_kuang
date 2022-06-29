package com.chen.尚硅谷.IO;

import org.junit.Test;

import java.io.*;

/**
 * @author chenchen
 * @date 2022-06-26 23:01
 */
public class FileReaderWriterTest {

    /*
    将文件(磁盘)内容读入到程序(内存)中，并输出到控制台
    注意这里抛出异常的方式，使用try-catch-finally，原因是中间抛出异常，后面的代码就不执行了，流就没有关闭
     */
    @Test
    public void test1() {
        FileReader fr = null;
        try {
            // 1.实例化File类对象，指明要操作的文件
            File file = new File("hello.txt");
            // 2.提供具体的流
            fr = new FileReader(file);
            // 3.数据的读入
            int read = fr.read();
            // // 另一种重载方法 begin
            // char[] cbuff = new char[5];
            // // read1 每次读取的字符的个数
            // int read1 = fr.read(cbuff);
            // String s = new String(cbuff, 1, read1);
            // // end
            while(read != -1){
                System.out.print((char) read);
                read = fr.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                // 4.流的关闭操作
                if(fr!=null){
                    fr.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }



    }

    /**
     * 数据的写出，从内存到磁盘
     * 文件会覆盖
     */
    @Test
    public void test2(){
        FileWriter fw = null;
        try {
            // 文件没有会创建，存在会覆盖
            File file = new File("hello1.txt");
            fw = new FileWriter(file,true);// true 为在原有基础追加
            fw.write("i have a dream?");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(fw!=null){
                try {
                    fw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    /**
     * 对文件复制：先读入然后写出去
     */
    @Test
    public void test3() throws IOException {
        File file1 = new File("hello.txt");
        File file2 = new File("hello1.txt");
        FileReader fr = new FileReader(file2);
        FileWriter fw = new FileWriter(file1);

        // int read;
        // while ((read = fr.read()) != -1){
        //    fw.write(read);
        // }

        // 复制图片使用字节流
        // 注意重载的方法
        char[] chars = new char[5];
        int len;
        while ((len = fr.read(chars))!=-1){
            fw.write(chars,0,len);
        }

        fr.close();
        fw.close();
    }

    /**
     * 实现对图片的复制
     *
     * 对于文本文件，使用字符流，也可也使用字节流（前提是不在内存中看）
     * 对于非文本文件，只能使用字节流
     */
    @Test
    public void test4() throws IOException {
        File file1 = new File("43991815.png");
        File file2 = new File("43991816.png");

        FileInputStream fileInputStream = new FileInputStream(file1);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);

        byte[] bytes = new byte[5];
        int len;
        while ((len = fileInputStream.read(bytes))!=-1){
            fileOutputStream.write(bytes,0,len);
        }
        fileInputStream.close();
        fileOutputStream.close();

    }

}

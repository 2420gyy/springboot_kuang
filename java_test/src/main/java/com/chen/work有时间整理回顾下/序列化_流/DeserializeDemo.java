package com.chen.work有时间整理回顾下.序列化_流;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeDemo {
    // 反序列化对象
    public static void main(String[] aogs) throws IOException, ClassNotFoundException {


        String pathname = System.getProperty("user.dir") + "/employee.ser";

        File file = new File(pathname);

        FileInputStream fileInputStream = new FileInputStream(file);

        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Employee employee = (Employee) objectInputStream.readObject();
        // 当对象被序列化时，属性 SSN 的值为 111222333，但是因为该属性是短暂的，该值没有被发送到输出流。
        System.out.printf(employee.toString());
        objectInputStream.close();
        fileInputStream.close();


    }
}

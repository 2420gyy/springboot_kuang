package com.chen.work有时间整理回顾下.序列化_流;

import java.io.*;

public class SerializableTest {
    public static void main(String[] args) {
        /*
        注意，static属性不能序列化，他是属于类的
         */
        try{
            FileOutputStream fos = new FileOutputStream("C:\\解密文件\\temp.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            User user = new User();
            user.setAge(18);
            user.setName("sandy");
            oos.writeObject(user);

            oos.flush();
            oos.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {

        }

        try {
            FileInputStream fis = new FileInputStream("C:\\解密文件\\temp.txt");
            ObjectInputStream oin = new ObjectInputStream(fis);
            User user = (User) oin.readObject();
            System.out.println("name="+user.getName());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}

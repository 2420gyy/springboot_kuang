package com.chen;

import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.Random;
import java.util.UUID;

/**
 * @author chenchen
 * @date 2021-12-23 16:53
 */
public class TestShiroMD5 {
    public static void main(String[] args) {
        // 创建md5算法
        // Md5Hash md5Hash = new Md5Hash();
        // md5Hash.setBytes("123".getBytes());
        // System.out.println(md5Hash.toHex());

        Md5Hash md5Hash = new Md5Hash("123");
        System.out.println(md5Hash.toHex());

        // 使用md5加salt
        String salt1 = UUID.randomUUID().toString();
        int i1 = new Random().nextInt(salt1.length() - 5 + 1)+5;
        String salt2 = salt1.substring(0,i1);
        salt2 = "X0*7ps";
        Md5Hash md5HashWSalt = new Md5Hash("123",salt2);
        System.out.println(md5HashWSalt);
        // 使用 md5 + salt + hash散列
        Md5Hash md5HashWSaltWHash = new Md5Hash("123",salt2,1024);
        System.out.println(md5HashWSaltWHash);
    }
}

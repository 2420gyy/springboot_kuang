package com.chen.springboot_jsp_shiro.utils;

import java.util.Random;

/**
 * @author chenchen
 * @date 2021-12-26 12:48
 */
public class SaltUtils {

    public static String getSalt(int n){
        char[] chars = "ABCDEFGHIJKLMNOPQRSTWXYZabcdefghijklmnopqrstwxyz0123456789!@#$%6&*()".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char aChar = chars[new Random().nextInt(chars.length)];
            sb.append(aChar);
        }
        return sb.toString();
    }
}

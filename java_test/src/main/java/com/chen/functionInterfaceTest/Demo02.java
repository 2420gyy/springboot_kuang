package com.chen.functionInterfaceTest;


import cn.hutool.core.util.StrUtil;

import java.util.function.Predicate;

/**
 * @author chenchen
 * @date 2021-12-01 23:19
 */
public class Demo02 {
    public static void main(String[] args) {
        // 判断字符串是否为空
        Predicate predicate = new Predicate<String>() {
            @Override
            public boolean test(String str) {
                if(StrUtil.isEmpty(str)){
                    return false;
                }
                return true;
            }
        };
        Predicate<String> predicate1 = str->StrUtil.isEmpty(str)?true:false;
        Predicate<String> predicate2 = str -> str.isEmpty();
        System.out.println(predicate.test(null));
        System.out.println(predicate1.test("s"));
        System.out.println(predicate2.test("ss"));
    }
}

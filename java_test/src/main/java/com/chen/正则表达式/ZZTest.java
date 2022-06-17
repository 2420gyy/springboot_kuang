package com.chen.正则表达式;

import cn.hutool.core.util.ReUtil;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author chenchen
 * @date 2022-01-14 9:59
 */
public class ZZTest {
    @Test
    public void test1(){
        // 原始方式
        String content = "ZZZaaabbbccc中文1234";
        String regex =""; //regex 正则表达式
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            String result= matcher.group();
        }

        // 使用hutool工具包
        // 抽取多个分组然后把它们拼接起来
        String content1 = "ZZZaaabbbccc中文1234";
        String resultExtractMulti = ReUtil.extractMulti("(\\w)aa(\\w)", content, "$1-$2");
        // Assert.assertEquals("Z-a", resultExtractMulti);
        System.out.println(resultExtractMulti);


        System.out.println("======");
    }
}

package com.lyx.utils;

import cn.hutool.core.date.DateUtil;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        System.out.println("进入StringToDateConverter");
//        if(s == null){
//            throw new RuntimeException("您输入的字符串不能为空！");
//        }
//        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
//        Date date = null;
//        try {
//            date = df.parse(s);
//        } catch (Exception e) {
//            throw new RuntimeException("转换出现错误！");
//        }
        Date date = DateUtil.parse(s, "yyyy-MM-dd");
        System.out.println("时间格式转换成功！");
        return date;
    }
}

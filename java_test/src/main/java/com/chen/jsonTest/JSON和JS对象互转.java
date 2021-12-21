package com.chen.jsonTest;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.chen.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * @author chenchen
 * @date 2021-12-01 19:45
 */
public class JSON和JS对象互转 {
    @Test
    public void test1(){
        String str = "{\"key\": 'value',\"key2\": 123,\"key3\": {\"name\": '啊',\"qq\": 12345},\"key4\": [1,2,3]}";
        JSONObject jsonObject1 = JSONUtil.parseObj(str);
        JSONObject key3 = (JSONObject)jsonObject1.get("key3");
        Object name = key3.get("name");
        System.out.println(name);

    }
    @Test
    public void test2(){
        Student stu1 = new Student(1, "chen", 23);
        String jsonStu = "{'id':1,'name':chen,'age':123}";
        Student student = JSONUtil.toBean(jsonStu, Student.class);
        System.out.println(student);
        System.out.println(student.getId());
    }
    @Test
    public void test3(){
        String str = "{\"0\":\"zhangsan\",\"1\":\"lisi\",\"2\":\"wangwu\",\"3\":\"maliu\"}";
        Map mapTypes = JSON.parseObject(str);
        System.out.println("这个是用JSON类的parseObject来解析JSON字符串!!!");
        for (Object obj : mapTypes.keySet()){
            System.out.println("key为："+obj+" 值为："+mapTypes.get(obj));
        }
    }

    @Test
    public void test(){
        String a = "0526b38c-5222-43be-a1e1-d094e5ab8539";
        System.out.println(a.length());
        java.util.Date date1 = new java.util.Date();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        System.out.println(date1);
        System.out.println(ft.format(date1));


        ZfPunishStaffBO person = new ZfPunishStaffBO();
        // List<ZfPunishStaffBO> person=null;
        person.setPersonId("");
        person.setPersonCode("");
        person.setPersonName("");
        person.setId("");
        System.out.println(person);
        if(ObjectUtils.isEmpty(person)){
            System.out.println("aaa");
        }
        if(person.getId()==""){
            System.out.println("sssssss");
        }
        if(person.getId().equals("")){
            System.out.println("pppppppppp");
        }
        if(StringUtils.isEmpty(person)){
            System.out.println("ccc");
        }
    }
}

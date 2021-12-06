package com.chen.jsonTest;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.chen.pojo.Student;
import org.junit.jupiter.api.Test;

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
}

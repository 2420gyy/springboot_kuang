package com.chen.jsonTest;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

/**
 * @author chenchen
 * @date 2021-12-01 15:07
 */
public class hutoolTest {
    public static void main(String[] args) {

        String jsonStr1 = "{\"key\": 'value',\"key2\": 123,\"key3\": {\"name\": '啊',\"qq\": 12345},\"key4\": [1,2,3]}";
        JSONObject jsonObject = JSONUtil.parseObj(jsonStr1);
        System.out.println(jsonObject);
        System.out.println(jsonObject.get("key3"));
        final JSONArray jsonArray1 = JSONUtil.parseArray(jsonStr1);
        // System.out.println(jsonArray1.getByPath("qq"));


        String jsonStr2 = "[{\"id\": \"1\",\"name\": \"a\"},{\"id\": \"2\",\"name\": \"b\"}]";
        final JSONArray jsonArray2 = JSONUtil.parseArray(jsonStr2);
        // b
        System.out.println(jsonArray2.getByPath("[1].name"));

    }
}

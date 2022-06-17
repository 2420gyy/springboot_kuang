package com.chen.jsonTest;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

/**
 * @author chenchen
 * @date 2022-04-29 13:45
 */
public class Test22 {
    public static void main(String[] args) {
        String jsonStr = "{\"alipay_trade_query_response\":{\"code\":\"10000\",\"msg\":\"Success\",\"buyer_logon_id\":\"jgv***@sandbox.com\",\"buyer_pay_amount\":\"0.00\",\"buyer_user_id\":\"2088622957299892\",\"buyer_user_type\":\"PRIVATE\",\"invoice_amount\":\"0.00\",\"out_trade_no\":\"d41d1b90-2902-42d8-8b74-ebd6c162973a\",\"point_amount\":\"0.00\",\"receipt_amount\":\"0.00\",\"send_pay_date\":\"2022-04-29 13:40:51\",\"total_amount\":\"12.00\",\"trade_no\":\"2022042922001499890502151583\",\"trade_status\":\"TRADE_SUCCESS\"},\"sign\":\"LomohFEPAfR0f1cBYezk5yeZw6HNUfhPtGR3cE/cGTx0xytdBkkKzWfhMYdOA1O2K6m5onKitov25pl3WsoPi5RlGOzOiphj8hGoMHquGMvE1DQJpVxskGtd0YlNVJjqvTqRHZUvEfZNGJD8Xgvzd8O2KTu+ezQJpy7WMJIf5nydSdFvRXWP0rBm0lRkb/tIKUmUNPrUCIudqWGdyNt1XlD8eyhE8U/vgK1ckKWaqupHj2wLXdRPUQt/zxiWY6ZkOHutU9gBYgn3CE/ol6Tivnse+HQGj1J1puI6u+q3Qo+HKheVaPgl5gR/DU9LJbG8TCJvwaCXvTrUQcvrgRqC/w==\"}";
        JSONObject jsonObject = JSONUtil.parseObj(jsonStr);
        JSONObject alipay_trade_query_response = jsonObject.getJSONObject("alipay_trade_query_response");
        System.out.println(alipay_trade_query_response.get("code"));


    }
}

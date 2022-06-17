package com.chen.service;

/**
 * @author chenchen
 * @date 2022-05-18 18:01
 */
public interface RedisService {

    int addSearchHistoryByUserId(String userid, String searchkey);
}

package com.chen.serviceImpl;

import com.chen.service.RedisService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chenchen
 * @date 2022-05-18 17:52
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;


    /**
     * @Author chenchen
     * @Description  新增一条该userid用户在搜索栏的历史记录
     * @Param searchkey 代表输入的关键词
     * @Date 18:02 2022/5/18
     **/
    @Override
    public int addSearchHistoryByUserId(String userid, String searchkey) {
        // 查找该用户在缓存中的查找记录 规定用户key的形式


        return 0;
    }
}

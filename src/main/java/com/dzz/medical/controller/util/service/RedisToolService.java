package com.dzz.medical.controller.util.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Redis相关操作封装
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年08月18 下午3:05
 */
@Service
public class RedisToolService {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 原子增长加1
     * @param key key
     * @return 结果
     */
    public Long readCountRecord(String key) {

       return redisTemplate.boundValueOps(key).increment(1L);
    }

    /**
     * 获取读取次数
     * @param key key
     * @return 结果
     */
    public Long getReadCount(String key) {

        return (Long) redisTemplate.boundValueOps(key).increment(0L);
    }
}

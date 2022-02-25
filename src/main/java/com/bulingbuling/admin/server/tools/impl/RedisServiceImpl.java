package com.bulingbuling.admin.server.tools.impl;

import com.bulingbuling.admin.server.tools.RedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RedisServiceImpl implements RedisService {

    @Resource
    private RedisTemplate<Object, Object> redisTemplate;	//Spring自动注入RedisTemplate

    @Override
    public void set(String key, String value) {
        // 20: 表示该数据在缓存中存在的时间，TimeUnit.SECONDS为单位秒，
        // 20秒后缓存中的数据会自动消失
//        redisTemplate.opsForValue().set(key,value,20, TimeUnit.SECONDS);
        redisTemplate.opsForValue().set(key,value);
    }

    @Override
    public String get(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }
}


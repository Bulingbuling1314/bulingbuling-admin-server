package com.bulingbuling.admin.server.user.service;

import com.bulingbuling.admin.server.common.ResultMap;
import com.bulingbuling.admin.server.common.Session;
import com.bulingbuling.admin.server.tools.JWTUtil;
import com.bulingbuling.admin.server.user.dao.MenuDo;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MenuService {
    ResultMap resultMap = new ResultMap();
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private MenuDo menuDo;

    public ResultMap getMenu() {
        String token = JWTUtil.verifyToken(String.valueOf(Session.getToken()));
//        redisTemplate.getDefaultSerializer();

        return resultMap.ok(200, token);
//        return resultMap.ok(200, menuDo.findAll());
    }
}

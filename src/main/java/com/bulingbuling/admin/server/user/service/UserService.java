package com.bulingbuling.admin.server.user.service;

import com.bulingbuling.admin.server.common.ResultMap;
import com.bulingbuling.admin.server.common.Session;
import com.bulingbuling.admin.server.tools.JWTUtil;
import com.bulingbuling.admin.server.user.dao.UserDo;
import com.bulingbuling.admin.server.user.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

@Service
@CacheConfig(cacheNames="userInfo")
public class UserService {
    private final Logger log = LoggerFactory.getLogger(UserService.class);

    ResultMap resultMap = new ResultMap();

    @Resource
    private UserDo userDo;

    public ResultMap getAllUser() {
        return resultMap.ok(200, userDo.findAll());
    }

    public ResultMap getUserByToken() {
        return resultMap.ok(200, userDo.findAll());
    }

    @Cacheable //开启缓存
    public ResultMap login(UserEntity data) {
        String userName = data.getUserName();
        String password = data.getPassword();
        HashMap<String, Object> result = new HashMap<>();
        UserEntity userInfo = userDo.findByUserName(userName);

        if(null != userInfo) {
            if(userInfo.getPassword().equals(password)) {
                String token = JWTUtil.createToken(String.valueOf(userInfo.getId()), 1000 * 60 * 30);
                Session.setToken(token);//设置token,参数token是要设置的具体值
                // 获取登录次数
                int count = userInfo.getLoginCount() + 1;
                userInfo.setLoginCount(count);
                userDo.save(userInfo);
                result.put("token", token);
                result.put("userName", userInfo.getUserName());
                result.put("password", userInfo.getPassword());
                result.put("nickName", userInfo.getNickName());
                result.put("role", userInfo.getRole());
                result.put("loginCount", count);
                return resultMap.ok(200, result);
            } else {
                return resultMap.error(201, "密码输入错误");
            }
        } else {
            return resultMap.error(204, "暂无该用户");
        }
    }
}

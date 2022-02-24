package com.bulingbuling.admin.server.user.service;

import com.bulingbuling.admin.server.common.ResultMap;
import com.bulingbuling.admin.server.tools.TokenProccessor;
import com.bulingbuling.admin.server.user.dao.UserDo;
import com.bulingbuling.admin.server.user.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

@Service
public class UserService {
    private final Logger log = LoggerFactory.getLogger(UserService.class);

    ResultMap resultMap = new ResultMap();

    TokenProccessor tokenProccessor = new TokenProccessor();

    @Resource
    private UserDo userDo;

    public ResultMap getAllUser() {
        return resultMap.ok(200, userDo.findAll());
    }

    public ResultMap login(UserEntity data) {
        String userName = data.getUserName();
        String password = data.getPassword();
        HashMap<String, String> result = new HashMap<>();
        UserEntity userInfo = userDo.findByUserName(userName);

        if(null != userInfo) {
            if(userInfo.getPassword().equals(password)) {
                // 获取登录次数
                int count = userInfo.getLoginCount() + 1;
                userInfo.setLoginCount(count);
                userDo.save(userInfo);
                result.put("token", tokenProccessor.makeToken());
                result.put("userName", userInfo.getUserName());
                result.put("password", userInfo.getPassword());
                result.put("nickName", userInfo.getNickName());
                result.put("role", userInfo.getRole());
                result.put("loginCount", String.valueOf(count));
                return resultMap.ok(200, result);
            } else {
                return resultMap.error(201, "密码输入错误");
            }
        } else {
            return resultMap.error(204, "暂无该用户");
        }
    }
}

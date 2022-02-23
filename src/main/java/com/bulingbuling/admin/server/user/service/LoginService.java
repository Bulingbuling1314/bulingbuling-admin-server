package com.bulingbuling.admin.server.user.service;

import com.bulingbuling.admin.server.common.ResultMap;
import com.bulingbuling.admin.server.tools.TokenProccessor;
import com.bulingbuling.admin.server.tools.entity.TokenEntity;
import com.bulingbuling.admin.server.user.dao.LoginDo;
import com.bulingbuling.admin.server.user.entity.LoginEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

@Service
public class LoginService {
    private final Logger log = LoggerFactory.getLogger(LoginService.class);

    ResultMap resultMap = new ResultMap();

    TokenProccessor tokenProccessor = new TokenProccessor();

    @Resource
    private LoginDo loginDo;

    public ResultMap getAllUser() {
        return resultMap.ok(200, loginDo.findAll());
    }

    public ResultMap login(LoginEntity data) {
        String userName = data.getUserName();
        String password = data.getPassword();
        HashMap<String, String> result = new HashMap<>();
        LoginEntity loginInfo = loginDo.findByUserName(userName);

        if(null != loginInfo) {
            if(loginInfo.getPassword().equals(password)) {
                result.put("token", tokenProccessor.makeToken());
                result.put("userName", loginInfo.getUserName());
                result.put("password", loginInfo.getPassword());
                result.put("nickName", loginInfo.getNickName());
                result.put("role", loginInfo.getRole());
                return resultMap.ok(200, result);
            } else {
                return resultMap.error(201, "密码输入错误");
            }
        } else {
            return resultMap.error(204, "暂无该用户");
        }
    }
}

package com.bulingbuling.admin.server.user.service;

import com.bulingbuling.admin.server.common.ResultMap;
import com.bulingbuling.admin.server.user.dao.LoginDo;
import com.bulingbuling.admin.server.user.entity.LoginEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginService {
    private final Logger log = LoggerFactory.getLogger(LoginService.class);

    ResultMap resultMap = new ResultMap();
    @Resource
    private LoginDo loginDo;
    public ResultMap create(LoginEntity data) {
        loginDo.save(data);
        return resultMap.ok(loginDo.findById(data.getId()));
    }

    public ResultMap find(int id) {
        return resultMap.ok(loginDo.findById(id).get());
    }
    public ResultMap findAll() {
        return resultMap.ok(loginDo.findAll());
    }
    public ResultMap remove(int id) {
        loginDo.deleteById(id);
        return resultMap.ok("操作成功！");
    }
}

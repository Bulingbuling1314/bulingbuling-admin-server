package com.bulingbuling.admin.server.admin.user.controller;

import com.bulingbuling.admin.server.admin.user.entity.UserEntity;
import com.bulingbuling.admin.server.admin.user.service.UserService;
import com.bulingbuling.admin.server.common.ResultMap;
import com.bulingbuling.admin.server.tools.IpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/bb/web/user")
public class UserController {
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/get")
    public ResultMap getAllUser() {
        return userService.getAllUser();
    }
    /**
     *  根据Token获取用户信息
     * */
    @RequestMapping(value = "/getUser")
    public ResultMap getUserByToken() {
        return userService.getUserByToken();
    }

    @RequestMapping(value = "/login")
    public ResultMap login(HttpServletRequest request, @RequestBody UserEntity data) {
        String ipAddress = IpUtil.getIpAddr(request);
        return userService.login(data, ipAddress);
    }
}

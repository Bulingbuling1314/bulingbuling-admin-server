package com.bulingbuling.admin.server.user.controller;

import com.bulingbuling.admin.server.user.entity.LoginEntity;
import com.bulingbuling.admin.server.user.service.LoginService;
import com.bulingbuling.admin.server.common.ResultMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/bb/web/user")
public class LoginController {
    private final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/get")
    public ResultMap getAllUser() {
        return loginService.getAllUser();
    }

    @RequestMapping(value = "/login")
    public ResultMap login(@RequestBody LoginEntity data) {
        return loginService.login(data);
    }
}

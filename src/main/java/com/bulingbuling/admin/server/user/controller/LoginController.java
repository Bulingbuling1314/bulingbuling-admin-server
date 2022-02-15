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
@RequestMapping(value = "/bb/web/")
public class LoginController {
    private final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/save")
    public ResultMap create(@RequestBody LoginEntity data) {
        return loginService.create(data);
    }
    @RequestMapping(value = "/getById")
    public ResultMap create(@RequestParam int id) {
        return loginService.find(id);
    }
    @RequestMapping(value = "/getAll")
    public ResultMap create() {
        return loginService.findAll();
    }
    @RequestMapping(value = "/remove")
    public ResultMap remove(@RequestParam int id) {
        return loginService.remove(id);
    }
}

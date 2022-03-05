package com.bulingbuling.admin.server.user.controller;

import com.bulingbuling.admin.server.common.ResultMap;
import com.bulingbuling.admin.server.user.entity.MenuEntity;
import com.bulingbuling.admin.server.user.entity.UserEntity;
import com.bulingbuling.admin.server.user.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/bb/web/menu")
public class MenuController {
    ResultMap resultMap = new ResultMap();

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/get")
    public ResultMap getMenu() {
        return resultMap.ok(200, menuService.getMenu());
    }

    @RequestMapping(value = "/add")
    public ResultMap add(@RequestBody MenuEntity menu) {
        return menuService.addMenu(menu);
    }
}

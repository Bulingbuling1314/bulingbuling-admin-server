package com.bulingbuling.admin.server.admin.user.controller;

import com.bulingbuling.admin.server.admin.user.entity.MenuEntity;
import com.bulingbuling.admin.server.admin.user.service.MenuService;
import com.bulingbuling.admin.server.common.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/remove")
    public ResultMap remove(@RequestParam int id) {
        return menuService.removeMenu(id);
    }
}

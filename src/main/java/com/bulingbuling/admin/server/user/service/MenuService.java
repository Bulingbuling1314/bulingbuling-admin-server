package com.bulingbuling.admin.server.user.service;

import com.bulingbuling.admin.server.common.ResultMap;
import com.bulingbuling.admin.server.user.dao.MenuDo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MenuService {
    ResultMap resultMap = new ResultMap();

    @Resource
    private MenuDo menuDo;

    public ResultMap getMenu() {
        return resultMap.ok(200, menuDo.findAll());
    }
}

package com.bulingbuling.admin.server.user.service;

import com.bulingbuling.admin.server.user.dao.MenuDo;
import com.bulingbuling.admin.server.user.entity.MenuEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuService {

    @Resource
    private MenuDo menuDo;

    public List<MenuEntity> getMenu() {
        return menuDo.findAll();
    }
}

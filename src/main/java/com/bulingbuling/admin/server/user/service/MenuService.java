package com.bulingbuling.admin.server.user.service;

import cn.hutool.json.JSONUtil;
import com.bulingbuling.admin.server.tools.RedisService;
import com.bulingbuling.admin.server.user.dao.MenuDo;
import com.bulingbuling.admin.server.user.entity.MenuEntity;
import com.bulingbuling.admin.server.user.entity.param.MenuEntityResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MenuService {

    @Autowired
    private RedisService redisService;

    @Resource
    private MenuDo menuDo;

    public List<MenuEntityResult> getMenu() {
        Map result = JSONUtil.parseObj(redisService.get("userInfo"));
        Object role = result.get("role");
        int parentId = 0;

        List<MenuEntity> menuList = menuDo.findByRole((String) role);

        List<MenuEntityResult> resultList = new ArrayList<>();
        this.initMenu(menuList, parentId, resultList, null);

        return resultList;
    }

    public void initMenu(List<MenuEntity> menuList, int parentId, List<MenuEntityResult> resultList, MenuEntityResult parent) {
        menuList.stream().filter(menu -> menu.getParentId() == parentId).forEach(menu -> {
            MenuEntityResult result = new MenuEntityResult();
            BeanUtils.copyProperties(menu, result);
            if (parent == null) {
                resultList.add(result);
            } else {
                parent.addChildren(result);
            }
            initMenu(menuList, result.getId(), null, result);
        });
    }
}

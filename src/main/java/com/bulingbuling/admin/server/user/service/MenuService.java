package com.bulingbuling.admin.server.user.service;

import cn.hutool.core.lang.Console;
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
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MenuService {

    @Autowired
    private RedisService redisService;

    @Resource
    private MenuDo menuDo;

    public List<MenuEntity> getMenu() {
        Map result = JSONUtil.parseObj(redisService.get("userInfo"));
        Object role = result.get("role");
        int parentId = 0;
        Console.log(result);
        List menuList = menuDo.findByRoleAndParentId((String) role, parentId);
        return formatMenu(menuList);
//        return menuDo.findAll();
    }

    private List<MenuEntityResult> formatMenu(List<MenuEntity> menuList) {

        // 1: 目录 2: 菜单

        List<MenuEntityResult> resultList = new ArrayList<>();
        for (MenuEntity result : menuList) {
            // 子集
            MenuEntityResult data = new MenuEntityResult();
            BeanUtils.copyProperties(result, data);
            if (result.getType() == 1) {
                List menuChilds = menuDo.findByRoleAndParentId(result.getRole(), result.getId());
                if (menuChilds != null && menuChilds.size() > 0) {
                    data.setChildren(menuChilds);
                }
            }
            resultList.add(data);
        }

        return resultList;
    }
}

package com.bulingbuling.admin.server.user.service;

import cn.hutool.json.JSONUtil;
import com.bulingbuling.admin.server.common.ResultMap;
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

    private ResultMap resultMap;
    @Resource
    private MenuDo menuDo;
    // 获取菜单
    public List<MenuEntityResult> getMenu() {
        Map result = JSONUtil.parseObj(redisService.get("userInfo"));
        Object role = result.get("role");
        int parentId = 0;

        List<MenuEntity> menuList = menuDo.findByRole((String) role);

        List<MenuEntityResult> resultList = new ArrayList<>();
        this.initMenu(menuList, parentId, resultList, null);

        return resultList;
    }
    // 递归查询菜单
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

    // 新增菜单
    public ResultMap addMenu(MenuEntity menu) {
        MenuEntity menuResult = menuDo.save(menu);
        return resultMap.ok(200, menuResult);
    }

    // 删除菜单
    public ResultMap removeMenu(int id) {
        menuDo.deleteById(id);
        return resultMap.ok(200, "操作成功");
    }
}

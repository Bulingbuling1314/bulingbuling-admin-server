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

    public List<MenuEntityResult> getMenu() {
        Map result = JSONUtil.parseObj(redisService.get("userInfo"));
        Object role = result.get("role");
        int parentId = 0;

        List<MenuEntity> menuList = menuDo.findByRole((String) role);

        List<MenuEntityResult> resultList = new ArrayList<>();
        this.initMenu(menuList,0,resultList,null);

        return resultList;
        //return formatMenu(menuList, resultList);
//        return menuDo.findAll();
    }

    public void initMenu(List<MenuEntity> menuList,int parentId,List<MenuEntityResult> resultList,MenuEntityResult parent){
        menuList.stream().filter(menu->menu.getParentId()==parentId).forEach(menu->{
            MenuEntityResult result = new MenuEntityResult();
            BeanUtils.copyProperties(menu,result);
            if(parent==null){
                resultList.add(result);
            }else{
                parent.addChildren(result);
            }
            initMenu(menuList,result.getId(),null,result);
        });
    }






    private List<MenuEntityResult> formatMenu(List<MenuEntityResult> menuList, List<MenuEntityResult> resultList) {
        // 1: 目录 2: 菜单
        for (MenuEntity result : menuList) {
            // 子集
            MenuEntityResult data = new MenuEntityResult();
            BeanUtils.copyProperties(result, data);
            if (result.getType() == 1) {
                List<MenuEntityResult> menuChilds = menuDo.findByRoleAndParentId(result.getRole(), result.getId());
                if (menuChilds != null && menuChilds.size() > 0) {
                    data.setChildren(menuChilds);
                    formatMenu(menuChilds, resultList);
                }
            }
            resultList.add(data);
        }
        return resultList;
    }
}

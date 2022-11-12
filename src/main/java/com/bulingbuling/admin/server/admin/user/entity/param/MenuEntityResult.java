package com.bulingbuling.admin.server.admin.user.entity.param;

import com.bulingbuling.admin.server.admin.user.entity.MenuEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


public class MenuEntityResult extends MenuEntity {

    @Setter @Getter
    private List<MenuEntityResult> children = new ArrayList<>();


    public void addChildren(MenuEntityResult result){
        this.children.add(result);
    }

}

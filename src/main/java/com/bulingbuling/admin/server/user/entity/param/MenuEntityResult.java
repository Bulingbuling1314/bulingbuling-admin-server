package com.bulingbuling.admin.server.user.entity.param;

import com.bulingbuling.admin.server.user.entity.MenuEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


public class MenuEntityResult extends MenuEntity {

    @Setter @Getter
    private List<MenuEntity> children = new ArrayList<>();

}

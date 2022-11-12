package com.bulingbuling.admin.server.admin.blog.vo;


import com.bulingbuling.admin.server.admin.blog.entity.CardEntity;
import lombok.Data;

import java.util.List;

@Data
public class NavEntityVO {

    private int id;

    private String name;

    private List<CardEntity> list;
}

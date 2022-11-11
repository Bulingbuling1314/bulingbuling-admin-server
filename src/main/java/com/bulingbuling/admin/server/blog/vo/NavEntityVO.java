package com.bulingbuling.admin.server.blog.vo;


import com.bulingbuling.admin.server.blog.entity.CardEntity;
import lombok.Data;

import java.util.List;

@Data
public class NavEntityVO {

    private int id;

    private String name;

    private List<CardEntity> list;
}

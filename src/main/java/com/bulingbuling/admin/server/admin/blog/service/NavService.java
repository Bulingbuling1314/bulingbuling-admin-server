package com.bulingbuling.admin.server.admin.blog.service;

import com.bulingbuling.admin.server.admin.blog.dao.CardDo;
import com.bulingbuling.admin.server.admin.blog.dao.NavDo;
import com.bulingbuling.admin.server.admin.blog.entity.CardEntity;
import com.bulingbuling.admin.server.admin.blog.entity.NavEntity;
import com.bulingbuling.admin.server.admin.blog.vo.NavEntityVO;
import com.bulingbuling.admin.server.common.ResultMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class NavService {

    private final Logger log = LoggerFactory.getLogger(NavService.class);

    ResultMap resultMap = new ResultMap();
    @Resource
    private NavDo navDo;
    @Resource
    private CardDo cardDo;

    public ResultMap create(NavEntity data) {
//        NavEntity nav = navDo.findById(data.getId()).orElse(null);
//        if(nav == null) {
//            data.setId(data.getId() + 1);
//        }
        navDo.save(data);
        return resultMap.ok(navDo.findById(data.getId()));
    }

    public ResultMap find(int id) {
        return resultMap.ok(navDo.findById(id).get());
    }

    public ResultMap findAll() {
        List<NavEntity> navList = navDo.findAll();
        List<CardEntity> cardList = cardDo.findAll();
        List<NavEntityVO> navResList = new ArrayList<>();
        List<CardEntity> cardResList = null;

        NavEntityVO str = null;
        for (NavEntity navEntity : navList) {
            str = new NavEntityVO();
            cardResList = new ArrayList<>();
            int navId = navEntity.getId();
            for (CardEntity cardEntity : cardList) {
                int cardId = cardEntity.getCardId();
                if(navId == cardId) {
                    cardResList.add(cardEntity);
                }
            }
            str.setId(navId);
            str.setName(navEntity.getName());
            str.setList(cardResList);
            navResList.add(str);
        }
        return resultMap.ok(navResList);
    }

    public ResultMap remove(int id) {
        NavEntity nav = navDo.findById(id).get();
        nav.setDeleteFlag(1);
        navDo.save(nav);
//        navDo.deleteById(id);
        return resultMap.ok("操作成功！");
    }
}

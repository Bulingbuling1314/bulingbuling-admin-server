package com.bulingbuling.admin.server.admin.blog.service;

import com.bulingbuling.admin.server.admin.blog.dao.CardDo;
import com.bulingbuling.admin.server.admin.blog.entity.CardEntity;
import com.bulingbuling.admin.server.common.ResultMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CardService {

    private final Logger log = LoggerFactory.getLogger(CardService.class);

    ResultMap resultMap = new ResultMap();
    @Resource
    private CardDo cardDo;
    public ResultMap create(CardEntity data) {
        data.setDeleteFlag(0);
        cardDo.save(data);
        return resultMap.ok(cardDo.findById(data.getId()));
    }

    public ResultMap find(int id) {
        return resultMap.ok(cardDo.findById(id).get());
    }

    public ResultMap findAll() {
        return resultMap.ok(cardDo.findAll());
    }
    public ResultMap remove(int id) {
        CardEntity card = cardDo.findById(id).get();
        card.setDeleteFlag(1);
        cardDo.save(card);
//        cardDo.deleteById(id);
        return resultMap.ok("操作成功！");
    }
}

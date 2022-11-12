package com.bulingbuling.admin.server.admin.blog.controller;

import com.bulingbuling.admin.server.admin.blog.entity.CardEntity;
import com.bulingbuling.admin.server.admin.blog.service.CardService;
import com.bulingbuling.admin.server.common.ResultMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/blog/card")
public class CardController {
        private final Logger log = LoggerFactory.getLogger(CardController.class);

        @Autowired
        private CardService cardService;

        @RequestMapping(value = "/save")
        public ResultMap create(@RequestBody CardEntity data) {
            return cardService.create(data);
        }
        @RequestMapping(value = "/getById")
        public ResultMap getById(@RequestParam int id) {
            return cardService.find(id);
        }
        @RequestMapping(value = "/getAll")
        public ResultMap getAll() {
            return cardService.findAll();
        }
        @RequestMapping(value = "/remove")
        public ResultMap remove(@RequestParam int id) {
            return cardService.remove(id);
        }
}

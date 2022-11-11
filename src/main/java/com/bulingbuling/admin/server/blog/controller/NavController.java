package com.bulingbuling.admin.server.blog.controller;

import com.bulingbuling.admin.server.blog.entity.NavEntity;
import com.bulingbuling.admin.server.blog.service.CardService;
import com.bulingbuling.admin.server.blog.service.NavService;
import com.bulingbuling.admin.server.common.ResultMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/blog/nav")
public class NavController {
        private final Logger log = LoggerFactory.getLogger(NavController.class);

        @Autowired
        private NavService navService;

        @Autowired
        private CardService cardService;

        @RequestMapping(value = "/save")
        public ResultMap create(@RequestBody NavEntity data) {
            return navService.create(data);
        }
        @RequestMapping(value = "/getById")
        public ResultMap getById(@RequestParam int id) {
            return navService.find(id);
        }
        @RequestMapping(value = "/getAll")
        public ResultMap getAll() {
            return navService.findAll();
        }
        @RequestMapping(value = "/remove")
        public ResultMap remove(@RequestParam int id) {
            return navService.remove(id);
        }
}

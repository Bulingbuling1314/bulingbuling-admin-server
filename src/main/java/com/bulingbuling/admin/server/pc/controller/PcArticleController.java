package com.bulingbuling.admin.server.pc.controller;

import com.bulingbuling.admin.server.admin.blog.service.ArticleService;
import com.bulingbuling.admin.server.common.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.core.SpringVersion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/blog/article")
public class PcArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/getAll")
    public ResultMap getAll() {
        return articleService.findAll();
    }

    @RequestMapping(value = "/getById")
    public ResultMap getAll(@RequestParam int id) {
        return articleService.findById(id);
    }
}


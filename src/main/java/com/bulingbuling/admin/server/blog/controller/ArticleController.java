package com.bulingbuling.admin.server.blog.controller;

import com.bulingbuling.admin.server.blog.entity.ArticleEntity;
import com.bulingbuling.admin.server.blog.service.ArticleService;
import com.bulingbuling.admin.server.common.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/bb/web/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/getAll")
    public ResultMap getAll() {
        return articleService.findAll();
    }

    @RequestMapping(value = "/create")
    public ResultMap create(@RequestBody ArticleEntity article) {
        return articleService.create(article);
    }
}

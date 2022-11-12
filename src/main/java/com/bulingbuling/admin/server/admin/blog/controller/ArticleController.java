package com.bulingbuling.admin.server.admin.blog.controller;

import com.bulingbuling.admin.server.admin.blog.entity.ArticleEntity;
import com.bulingbuling.admin.server.admin.blog.service.ArticleService;
import com.bulingbuling.admin.server.common.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/save")
    public ResultMap save(@RequestBody ArticleEntity article) {
        return articleService.create(article);
    }

    @RequestMapping(value = "/removeById")
    public ResultMap remove(@RequestParam int id) {
        return articleService.remove(id);
    }
}

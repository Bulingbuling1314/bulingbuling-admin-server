package com.bulingbuling.admin.server.admin.blog.service;

import com.bulingbuling.admin.server.admin.blog.dao.ArticleDo;
import com.bulingbuling.admin.server.admin.blog.entity.ArticleEntity;
import com.bulingbuling.admin.server.admin.blog.entity.NavEntity;
import com.bulingbuling.admin.server.common.ResultMap;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ArticleService {
    ResultMap resultMap = new ResultMap();
    @Resource
    private ArticleDo articleDo;

    public ResultMap findAll() {
        return resultMap.ok(articleDo.findAll());
    }
    public ResultMap findById(int id) {
        return resultMap.ok(articleDo.findById(id));
    }
    public ResultMap create(ArticleEntity article) {
        // 创建时间
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        article.setCreateDate(sdf.format(d));
        article.setUpdateDate(sdf.format(d));
        article.setAuthor("A . 阿冰");
        return resultMap.ok(articleDo.save(article));
    }

    public ResultMap remove(int id) {
        ArticleEntity article = articleDo.findById(id).get();
        article.setDeleteFlag(1);
        articleDo.save(article);
        return resultMap.ok("success");
    }
}

package com.bulingbuling.admin.server.blog.dao;

import com.bulingbuling.admin.server.blog.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleDo extends JpaRepository<ArticleEntity, Integer> {
    @Query(value ="select * from blog_article where delete_flag == 0", nativeQuery = true)
    List<ArticleEntity> findAll();
}

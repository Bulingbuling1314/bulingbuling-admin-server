package com.bulingbuling.admin.server.blog.dao;

import com.bulingbuling.admin.server.blog.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardDo extends JpaRepository<CardEntity, Integer> {
    @Query(value ="select * from blog_card_bar where delete_flag = 0", nativeQuery = true)
    List<CardEntity> findAll();
}

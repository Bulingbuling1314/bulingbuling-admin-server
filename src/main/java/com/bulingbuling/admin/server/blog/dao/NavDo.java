package com.bulingbuling.admin.server.blog.dao;

import com.bulingbuling.admin.server.blog.entity.NavEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NavDo extends JpaRepository<NavEntity, Integer> {
    @Query(value ="select * from blog_nav_bar where delete_flag = 0", nativeQuery = true)
    List<NavEntity> findAll();
}

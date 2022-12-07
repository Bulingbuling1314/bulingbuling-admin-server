package com.bulingbuling.admin.server.pc.dao;

import com.bulingbuling.admin.server.pc.entity.PageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PageDo extends JpaRepository<PageEntity, Integer> {
    @Query(value ="select distinct page_name from page_logging", nativeQuery = true)
    List<String> findAllPageName();

    @Query(value ="select count(*) from page_logging where page_logging.page_name = ?1", nativeQuery = true)
    int findCountByPageName(String pageName);
}

package com.bulingbuling.admin.server.user.dao;

import com.bulingbuling.admin.server.user.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuDo extends JpaRepository<MenuEntity, Integer> {

    List findByRoleAndParentId(String role, int parentId);

    List findByRoleAndId(String role, int id);
}

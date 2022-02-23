package com.bulingbuling.admin.server.user.dao;

import com.bulingbuling.admin.server.user.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuDo extends JpaRepository<MenuEntity, Integer> {
}

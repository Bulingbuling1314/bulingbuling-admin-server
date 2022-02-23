package com.bulingbuling.admin.server.user.dao;

import com.bulingbuling.admin.server.user.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDo extends JpaRepository<LoginEntity, Integer> {
    LoginEntity findByUserName(String username);
}

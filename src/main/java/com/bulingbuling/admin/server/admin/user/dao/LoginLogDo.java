package com.bulingbuling.admin.server.admin.user.dao;

import com.bulingbuling.admin.server.admin.user.entity.LoginLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginLogDo extends JpaRepository<LoginLogEntity, Integer> {
}

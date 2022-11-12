package com.bulingbuling.admin.server.admin.user.dao;

import com.bulingbuling.admin.server.admin.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDo extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUserName(String username);
}

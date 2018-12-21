package com.qihong.demojdbc.dao;

import com.qihong.demojdbc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {
}

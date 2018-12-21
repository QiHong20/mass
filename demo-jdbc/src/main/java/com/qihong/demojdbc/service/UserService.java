package com.qihong.demojdbc.service;

import com.qihong.demojdbc.dao.UserDao;
import com.qihong.demojdbc.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserDao userDao;

    @Transactional
    public void save(User user){

        userDao.save(user);
        logger.info("save {}",user.getName());
        int a=1;
        int b=2;
    }
}

package com.example.demomultisourceofmybatis.service;

import com.example.demomultisourceofmybatis.entity.User;
import com.example.demomultisourceofmybatis.entity.UserPass;
import com.example.demomultisourceofmybatis.mapper1.UserMapper;
import com.example.demomultisourceofmybatis.mapper2.UserPassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * test1 数据库
 */
@Service
@Transactional("transactionManager1")
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public User getByName(String name){
        return userMapper.getByName(name);
    }

    /***
     *
     * @param name
     * @param age
     * @param toSucc  希望成功更新吗
     */
    public void testTransaction(String name,int age,boolean toSucc){
        userMapper.update(name,age);
        if(!toSucc){
            int a=10/0;
        }
        return ;
    }


}

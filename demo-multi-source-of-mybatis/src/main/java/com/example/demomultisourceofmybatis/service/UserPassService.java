package com.example.demomultisourceofmybatis.service;


import com.example.demomultisourceofmybatis.entity.UserPass;
import com.example.demomultisourceofmybatis.mapper2.UserPassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/***
 * tset2数据库
 */
@Service
@Transactional("transactionManager2")
public class UserPassService {


    @Autowired
    private UserPassMapper userPassMapper;



    public UserPass getByUser(String user){
        return userPassMapper.getByUser(user);
    }

    /***
     *
     * @param user
     * @param password
     * @param toSucc  希望成功更新吗
     */
    public void testTransaction(String user,String password,boolean toSucc){
        userPassMapper.update(user,password);
        if(!toSucc){
            int a=10/0;
        }
        return ;
    }
}

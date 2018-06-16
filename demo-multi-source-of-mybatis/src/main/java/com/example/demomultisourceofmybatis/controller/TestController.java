package com.example.demomultisourceofmybatis.controller;

import com.example.demomultisourceofmybatis.entity.User;
import com.example.demomultisourceofmybatis.entity.UserPass;
import com.example.demomultisourceofmybatis.service.UserPassService;
import com.example.demomultisourceofmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class TestController {

    @Autowired
    private UserService userService;


    @Autowired
    private UserPassService userPassService;

    @Autowired
    private User user;


//    @Autowired
//    private DataSource dataSource;


    @RequestMapping("/user")
    public User getUser(String name){
        return userService.getByName(name);
    }

    @RequestMapping("/userPass")
    public UserPass getPass(String user){
        return userPassService.getByUser(user);
    }


    @RequestMapping("/test")
    public User test(String name){
        return user;
    }
    @RequestMapping("/testTest1Transaction")
    public void testTest1Transaction(String user,int age,int toSucc){
        if(toSucc==1){
            userService.testTransaction(user,age,true);
        }else{
            userService.testTransaction(user,age,false);
        }
    }


    @RequestMapping("/testTest2Transaction")
    public void testTest2Transaction(String user,String password,int toSucc){
        if(toSucc==1){
            userPassService.testTransaction(user,password,true);
        }else{
            userPassService.testTransaction(user,password,false);
        }
    }

    @RequestMapping("/testMultiTransactionManager")
    public void testMultiTransactionManager(String user,String password,int toSucc){
        if(toSucc==1){
            userPassService.testTransaction(user,password,true);
        }else{
            userPassService.testTransaction(user,password,false);
        }
    }

}

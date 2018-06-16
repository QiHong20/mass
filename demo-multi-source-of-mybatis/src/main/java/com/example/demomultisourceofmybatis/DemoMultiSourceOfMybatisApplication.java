package com.example.demomultisourceofmybatis;

import com.example.demomultisourceofmybatis.entity.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@MapperScan("com.example.demomultisourceofmybatis.mapper1")
public class DemoMultiSourceOfMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoMultiSourceOfMybatisApplication.class, args);
    }


    @Bean
    public User getUser(){
        User user =new User();
        user.setAge(123);
        user.setName("12");
        return user;
    }
}

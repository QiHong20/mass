package com.example.demotestloadblane.config;

import com.example.demotestloadblane.domain.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConifg {
    @Bean("user1")
    @LoadBalanced
    public User getUser(){
        User user=new User();
        user.setAge(18);
        user.setName("123");
        return user;
    }

    @Bean("user2")
    @LoadBalanced
    public User getUser2(){
        User user=new User();
        user.setAge(17);
        user.setName("1233");
        return user;
    }
}

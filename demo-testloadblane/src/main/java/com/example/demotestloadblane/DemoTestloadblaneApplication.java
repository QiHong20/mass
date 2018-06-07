package com.example.demotestloadblane;

import com.example.demotestloadblane.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAutoConfiguration
@RestController
public class DemoTestloadblaneApplication {

    @Autowired
   @LoadBalanced
    private User user;

    public static void main(String[] args) {
        SpringApplication.run(DemoTestloadblaneApplication.class, args);
    }
    @RequestMapping("/user")
    public User getUser(){
        return user;
    }
}

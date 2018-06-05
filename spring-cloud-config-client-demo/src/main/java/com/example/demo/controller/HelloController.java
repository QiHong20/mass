package com.example.demo.controller;

import com.example.democommon.dto.UserDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${nickName}")
    private String nickName;

    @RequestMapping("/hello")
    public String hello(){
        return nickName;
    }

    @RequestMapping("/user")
    public UserDTO user(){
        UserDTO userDTO=new UserDTO();
        userDTO.setAge(18);
        userDTO.setName("小明");
        return userDTO;
    }
}

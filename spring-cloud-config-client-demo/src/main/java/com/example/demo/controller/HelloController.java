package com.example.demo.controller;

import com.example.demo.dto.IncloudInnerClassDto;
import com.example.demo.dto.UserDTO;
import com.sun.org.apache.bcel.internal.classfile.InnerClass;
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

    @RequestMapping("/testInner")
    public IncloudInnerClassDto testInner(){
        IncloudInnerClassDto dto=new IncloudInnerClassDto();

        IncloudInnerClassDto.Inner inner=dto.getInner();
        inner.setName("小明");
        inner.setAge(16);

        return dto;
    }
}

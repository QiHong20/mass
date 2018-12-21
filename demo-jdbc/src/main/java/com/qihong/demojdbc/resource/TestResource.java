package com.qihong.demojdbc.resource;

import com.qihong.demojdbc.entity.User;
import com.qihong.demojdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResource {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public void test(@RequestBody User user){
        userService.save(user);
    }
}

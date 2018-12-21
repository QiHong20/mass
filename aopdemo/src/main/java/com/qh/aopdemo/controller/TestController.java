package com.qh.aopdemo.controller;

import com.qh.aopdemo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;
    @RequestMapping("/test")
    public String test(){
        testService.test();
        return "success";
    }
    @RequestMapping("/test2")
    public String test2(){
        testService.test2();
        return "success";
    }
   
}

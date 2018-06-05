package com.example.demo.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TestScheduleService {
    @Scheduled(cron = "*/1 * * * * ?")
    public void test1(){
        System.out.println("this is test1");
    }
}

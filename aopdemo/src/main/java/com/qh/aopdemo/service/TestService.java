package com.qh.aopdemo.service;

import com.qh.aopdemo.aop.Log;
import com.qh.aopdemo.aop.LogAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TestService {
    private Logger logger=LoggerFactory.getLogger(this.getClass());
    @Log(desc = "this is desc",action = "this is action")
    public String test(){
        String uuid=UUID.randomUUID().toString();
        LogAspect.threadLocal.get().put("uuid",uuid);
        logger.info("设置uuid"+uuid);
        return "test";
    }
    @Log(desc = "this is desc",action = "this is action")
    public String test2(){
        return 1/0+"";
    }
}

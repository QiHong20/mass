package com.qihong.demodubboprovider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.qihong.demodubboapi.service.HelloService;
import org.springframework.stereotype.Component;

@Service(interfaceClass = HelloService.class)
@Component
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "hello "+name;
    }
}

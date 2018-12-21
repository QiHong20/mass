package com.qihong.demodubboconsumer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class DemoDubboConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoDubboConsumerApplication.class, args);
    }

}


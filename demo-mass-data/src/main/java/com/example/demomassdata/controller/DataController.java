package com.example.demomassdata.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class DataController {

    @RequestMapping("goods")
    public String getGoods() throws IOException {
        Resource resource=new ClassPathResource("goods.json");
        String content= IOUtils.toString(resource.getInputStream());
        return content;
    }

}

package com.example.demomassdata.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DataController {

    @RequestMapping("goods")
    public String getGoods() throws IOException {
        Resource resource=new ClassPathResource("goods.json");
        String content= IOUtils.toString(resource.getInputStream());
        return content;
    }

    @RequestMapping("/jx_business/v1/api/person/{id}")
    public String personInfo() throws IOException {
        Resource resource=new ClassPathResource("personInfoData.json");
        String content= IOUtils.toString(resource.getInputStream());
        return content;
    }
    @RequestMapping("/jx_business/v1/api/business/{id}")
    public String businessInfo() throws IOException {
        Resource resource=new ClassPathResource("businessInfoData.json");
        String content= IOUtils.toString(resource.getInputStream());
        return content;
    }
    @RequestMapping("/jx_business/v1/api/business/hotPoint")
    public String businesshotPoint() throws IOException {
        Resource resource=new ClassPathResource("businessSearchHot.json");
        String content= IOUtils.toString(resource.getInputStream());
        return content;
    }

    @RequestMapping("/jx_business/v1/api/person/hotPoint")
    public String personhotPoint() throws IOException {
        Resource resource=new ClassPathResource("personSearchHot.json");
        String content= IOUtils.toString(resource.getInputStream());
        return content;
    }
    @RequestMapping("/jx_business/v1/api/business/search")
    public String businessSearch() throws IOException {
        Resource resource=new ClassPathResource("businessSearch.json");
        String content= IOUtils.toString(resource.getInputStream());
        return content;
    }
    @RequestMapping("/jx_business/v1/api/person/search")
    public String personSearch() throws IOException {
        Resource resource=new ClassPathResource("personSearch.json");
        String content= IOUtils.toString(resource.getInputStream());
        return content;
    }

    @RequestMapping("columns")
    public List<String> getColumn(){
        List<String>columns=new ArrayList<>();
        Class clazz=ABCD.class;
        Field[] fields=clazz.getFields();
        Field[] fields2=clazz.getDeclaredFields();

        columns.add(clazz.getSimpleName());
        for(Field field:fields){
            columns.add(field.getName());
        }
        for(Field field:fields2){
            columns.add(field.getName());
        }
        return columns;
    }

    public class ABCD{
        private String AAA;
        private String BBB;
        private String CCC;

    }
}

package com.example.demomassdata.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

@RestController
public class DataController {

    private TreeSet<BusinessHotPointItem>tree=new TreeSet<>();
    {

        this.add(new BusinessHotPointItem("1",0));
        this.add(new BusinessHotPointItem("2",0));
        this.add(new BusinessHotPointItem("3",0));
        this.add(new BusinessHotPointItem("3",0));
        this.add(new BusinessHotPointItem("3",0));
        this.add(new BusinessHotPointItem("1",0));
    }
    @RequestMapping("goods")
    public String getGoods() throws IOException {
        Resource resource=new ClassPathResource("goods.json");
        String content= IOUtils.toString(resource.getInputStream());
        return content;
    }

    private void add(BusinessHotPointItem item){
        if(tree.contains(item)){
            BusinessHotPointItem temp= tree.ceiling(item);
            temp.setCount(temp.getCount()+1);
            tree.add(temp);
        }else{
            tree.add(item);
        }
    }
    @RequestMapping("/getTop")
    public List<BusinessHotPointItem> personSearch() throws IOException {
        List<BusinessHotPointItem> items=new ArrayList<>();
        BusinessHotPointItem item=tree.last();
        items.add(item);
        for(int i=0;i<2;i++){
            item=tree.lower(item);
            if(item==null){
                break;
            }
            items.add(item);
        }

        return items;
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

     class BusinessHotPointItem implements Comparable<BusinessHotPointItem>{
        /**
         * 热点返回的值，可
         */
        @JsonProperty("PARAM")
        private String param;

        @JsonIgnore
        private int count;

        public String getParam() {
            return param;
        }

        public void setParam(String param) {
            this.param = param;
        }

        @Override
        public int compareTo(BusinessHotPointItem o) {
            if(o.getParam().equals(this.getParam())) {
                return 0;
            }
            if(this.getCount()-o.getCount()<0){
               return -1;
            }else{
                return 1;
            }


        }

         public int getCount() {
             return count;
         }

         public void setCount(int count) {
             this.count = count;
         }

         @Override
        public int hashCode() {
            // TODO Auto-generated method stub
            return super.hashCode();
        }

         public BusinessHotPointItem(String param, int count) {
             this.param = param;
             this.count = count;
         }
     }

}

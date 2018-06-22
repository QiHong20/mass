package com.example.demomassdata.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class TestService {
    private final static Logger logger =LogManager.getLogger(TestService.class);
    public static void  main(String[]args){
        TestService service=new TestService();

        Person person=service.getBean(new Person());
    }

    public static class Dog{
        private int age;
        private String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    public static class Person{
        private int age;
        private String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    /**
     * 尝试获取bean的类型
     * @param bean
     * @param <T>
     * @return
     */
    public <T> T getBean(T bean){
        logger.info(bean);
        return bean;
    }


}

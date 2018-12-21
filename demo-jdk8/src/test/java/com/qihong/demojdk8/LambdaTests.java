package com.qihong.demojdk8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LambdaTests {

    public static Logger logger= LoggerFactory.getLogger(LambdaTests.class);

    public static void main(String[] args){
//        new Thread(()->{
//            logger.info("thread is {}...",Thread.currentThread().getName());
//        }).start();
//        logger.info("thread is {} main",Thread.currentThread().getName());

//        A a=new A(123);
//        a.invokePrintInt((aa)->{
//            logger.info("int is {}",aa);
//        });
    }
    static class A{
        int a;

        public A(int a) {
            this.a = a;
        }

        public void invokePrintInt(PrintIntr p){
            p.print(a);
        }
    }

    @FunctionalInterface
    interface  PrintIntr{
        void print(int a);
    }
}

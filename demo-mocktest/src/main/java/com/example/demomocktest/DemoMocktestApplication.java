package com.example.demomocktest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.LinkedList;

import static org.mockito.Mockito.*;

@SpringBootApplication
public class DemoMocktestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoMocktestApplication.class, args);
    }


    public static class TestUnit {


        @Before
        public void before() {
            MockitoAnnotations.initMocks(this);
        }

        @Test
        public void testSort() {

            // you can mock concrete classes, not only interfaces
            LinkedList mockedList = mock(LinkedList.class);

// stubbing appears before the actual execution
            when(mockedList.get(0)).thenReturn("first");

// the following prints "first"
            System.out.println(mockedList.get(0));

// the following prints "null" because get(999) was not stubbed
            System.out.println(mockedList.get(999));
        }



    }
}

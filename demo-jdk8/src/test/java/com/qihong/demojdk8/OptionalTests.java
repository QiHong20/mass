package com.qihong.demojdk8;

import org.junit.Test;

import java.util.Optional;

public class OptionalTests {


    @Test
    public void testOptional(){
        Optional<Integer> a=Optional.ofNullable(null);
        if(a.isPresent()){
            a.orElse(123);
        }
    }
}

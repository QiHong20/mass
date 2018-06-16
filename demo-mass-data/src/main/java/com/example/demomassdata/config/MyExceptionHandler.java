package com.example.demomassdata.config;

import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

@ControllerAdvice(annotations = { RestController.class })
@ResponseBody
public class MyExceptionHandler   extends ResponseEntityExceptionHandler{


    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<ErrorResult>handle(FileNotFoundException e,HttpServletRequest request){
        ErrorResult errorResult=new ErrorResult();
        errorResult.setCode(500);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));

        return new ResponseEntity<ErrorResult>(errorResult,headers,HttpStatus.BAD_GATEWAY);

    }
    @Scheduled(cron = "*/30 * * * * ?")
    public void test(){
        System.out.println(new Date()+"123");
    }
}

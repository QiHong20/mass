package com.example.demouseimagemagick;

import org.im4java.core.ConvertCmd;
import org.im4java.core.IMOperation;
import org.im4java.process.Pipe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoUseImagemagickApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoUseImagemagickApplication.class, args);
    }

    @RequestMapping("/test")
    public void test()throws  Exception{
        IMOperation operation = new IMOperation();
        operation.addImage("f:\\temp\\1.jpg");
//        operation.rotate(90d);
        operation.resize(100,100);
        operation.addImage("f:\\temp\\1_resize.jpg");



        ConvertCmd cmd = new ConvertCmd();
        cmd.setSearchPath("C:\\Program Files\\ImageMagick-7.0.8-Q16\\");  //Windows需要设置，Linux不需要
        cmd.run(operation);
    }

}

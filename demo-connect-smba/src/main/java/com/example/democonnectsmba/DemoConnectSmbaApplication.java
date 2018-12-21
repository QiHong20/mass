package com.example.democonnectsmba;

import jcifs.smb.SmbFile;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController
public class DemoConnectSmbaApplication {

    private Logger logger=LoggerFactory.getLogger(DemoConnectSmbaApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(DemoConnectSmbaApplication.class, args);
    }

    @RequestMapping("test")
    public String test() throws Exception {

        String username = "qihong";
        String password = "qihong19951216";
        String host = "192.168.1.182";
        String path = "/share";
    //        String remoteUrl = "smb://" + username + ":" + password + "@" + host + path + (path.endsWith("/") ? "" : "/");
            String remoteUrl = "smb://" + host + path + (path.endsWith("/") ? "" : "/");
        SmbFile remoteFile = new SmbFile(remoteUrl);
        remoteFile.connect();
        if (remoteFile.isDirectory()) {
            String[] files = remoteFile.list();
            for (String fileName : files) {
                SmbFile file = new SmbFile(remoteFile.getPath()+ (path.endsWith("/") ? "" : "/" + fileName));
                if(file.isFile()){
                    logger.info(IOUtils.toString(file.getInputStream()));
                }
            }
        }

        return "";
    }

}

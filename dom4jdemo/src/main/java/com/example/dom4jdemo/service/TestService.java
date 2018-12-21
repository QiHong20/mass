package com.example.dom4jdemo.service;

import com.example.dom4jdemo.Dom4jdemoApplication;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;

import java.util.List;

public class TestService {
    public static Logger logger =LoggerFactory.getLogger(TestService.class);
    public static void main(String[] args) throws  Exception {

        String dom="<C><E>仰向け|仰向けれ|仰向けよ|仰向けろ|あお向ける|あお向け|あお向けれ|あお向けよ|あお向けろ|仰向る|仰向|仰向れ|仰向よ|仰向ろ</E><F><H><M>あおむける</M></H><I><N><Q>仰，仰起</Q></N></I></F></C><C><E>仰向い|仰向か|仰向き|仰向け|仰向こ|仰むく|仰むい|仰むか|仰むき|仰むけ|仰むこ|あお向く|あお向い|あお向か|あお向き|あお向け|あお向こ</E><F><H><M>あおむく</M></H><I><N><Q>仰，向上仰</Q></N></I></F></C>";
        Document document = DocumentHelper.parseText(dom);
        Element root=document.getRootElement();
        List<Node> nodes=root.content();

        for(Node node:nodes){
            if("F".equals(node.getName())){

            }
        }

    }
}

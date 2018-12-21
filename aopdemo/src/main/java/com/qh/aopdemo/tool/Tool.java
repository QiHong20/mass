package com.qh.aopdemo.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tool {
    private static Logger logger =LoggerFactory.getLogger(Tool.class);
    public static String formatHolderPlace(String desc, Map<String,Object>para){
        String patt = "\\{(.*?)\\}";

        // 用于测试的输入字符串
//        System.out.println("Input:" + desc);

        // 从正则表达式实例中运行方法并查看其如何运行
        Pattern r = Pattern.compile(patt);
        Matcher m = r.matcher(desc);
//        System.out.println("ReplaceAll:" + m.replaceAll("favour"));

        // appendReplacement方法
        m.reset();
        StringBuffer sb = new StringBuffer();
        while (m.find()) {

            // 将匹配之前的字符串复制到sb,再将匹配结果替换为："favour"，并追加到sb
            m.appendReplacement(sb, m.group(1));
        }
        System.out.println(sb.toString());
        m.appendTail(sb);
        System.out.println(sb.toString());
        return sb.toString();
    }
    public static void main( String args[] ){
        Tool.formatHolderPlace("123123{name}sfsdf{age}",null);
    }
}

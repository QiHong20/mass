package com.example.kuromojidemo.service;



import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.ja.JapaneseAnalyzer;
import org.apache.lucene.analysis.ja.JapaneseTokenizer;
import org.apache.lucene.analysis.ja.Token;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.nio.file.attribute.AclEntry;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;


public class TestService {
    private static Logger logger =LoggerFactory.getLogger(TestService.class);
   /* public static void main(String[] args){
        String word = "日本経済新聞でモバゲーの記事を読んだ。";
        AclEntry.Builder builder = Tokenizer.builder();

// Normal
        Tokenizer normal = builder.build();
        List<Token> tokensNormal = normal.tokenize(word);
        disp(tokensNormal);

// Search
        builder.mode(JapaneseTokenizer.Mode.SEARCH);
        Tokenizer search = builder.build();
        List<Token> tokensSearch = search.tokenize(word);
        disp(tokensSearch);

// Extends
        builder.mode(JapaneseTokenizer.Mode.EXTENDED);
        Tokenizer extended = builder.build();
        List<Token> tokensExtended = extended.tokenize(word);
        disp(tokensExtended);
    }*/

    public static void main(String[] args) throws  Exception{
        Analyzer analyzer=new JapaneseAnalyzer();
//        Analyzer analyzer=new SmartChineseAnalyzer();
        Set<String> words=new HashSet<>();
        // 2、从分析器对象中获得tokenStream对象
        // 参数1：域的名称，可以为null，或者是""
        // 参数2：要分析的文本
//        TokenStream tokenStream = analyzer.tokenStream("", "日本経済新聞でモバゲーの記事を読んだ。，即行数据java，可以用二维表结构来逻辑表达实现的数据。");
        TokenStream tokenStream = analyzer.tokenStream("", "[00:25.628]薄红の秋桜が秋の日の\\n[00:31.337]何気ない阳溜りに揺れている\\n[00:37.317]この頃 涙脆くなった母が\\n[00:44.29]庭先でひとつ咳をする\\n[00:50.974]縁侧でアルバムを開いては\\n[00:56.901]私の幼い日の思い出を\\n[01:02.746]何度も同じ话くりかえす\\n[01:09.215]独言みたいに小さな声で\\n[01:17.334]こんな小春日和の穏やかな日は\\n[01:24.189]あなたの優しさが浸みて来る\\n[01:29.787]明日嫁ぐ私に苦労はしても\\n[01:36.752]笑い话に时が変えるよ\\n[01:40.62]心配いらないと笑った\\n[01:59.535]あれこれと思い出をたどったら\\n[02:05.379]いつの日もひとりではなかったと\\n[02:11.359]今更ながらわがままな私に\\n[02:18.159]唇かんでいます\\n[02:24.885]明日への荷造りに手を借りて\\n[02:30.741]しばらくは楽し気にいたけれど\\n[02:36.787]突然涙こぼし元気でと\\n[02:43.506]何度も何度もくりかえす母\\n[02:51.15]ありがとうの言葉をかみしめながら\\n[02:58.240]生きてみます私なりに\\n[03:03.917]こんな小春日和の隠やかな日は\\n[03:10.828]もう少しあなたの子供で\\n[03:15.290]いさせてください\\n");

        // 3、设置一个引用(相当于指针)，这个引用可以是多种类型，可以是关键词的引用，偏移量的引用等等
        CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class); // charTermAttribute对象代表当前的关键词
        // 偏移量(其实就是关键词在文档中出现的位置，拿到这个位置有什么用呢？因为我们将来可能要对该关键词进行高亮显示，进行高亮显示要知道这个关键词在哪？)
        OffsetAttribute offsetAttribute = tokenStream.addAttribute(OffsetAttribute.class);
        // 4、调用tokenStream的reset方法，不调用该方法，会抛出一个异常
        tokenStream.reset();
        String pattern = "^\\d+$";
        // 5、使用while循环来遍历单词列表
        while (tokenStream.incrementToken()) {
//            System.out.println("start→" + offsetAttribute.startOffset()); // 关键词起始位置
            // 6、打印单词
//            System.out.println(charTermAttribute);
            String word=charTermAttribute.toString();
            boolean isMatch = Pattern.matches(pattern, word);
            if(isMatch){
                logger.info("is number :{}",word);
            }
            else {
                words.add(word);
            }
//            System.out.println("end→" + offsetAttribute.endOffset()); // 关键词结束位置
        }
        System.out.println(words);
        // 7、关闭tokenStream对象
        tokenStream.close();
    }
}

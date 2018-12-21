package com.qihong.demorxjava;


import org.junit.Test;
import rx.subjects.PublishSubject;
import rx.subjects.ReplaySubject;

public class RxJavaTests {

    /**
     * 普通的发布者
     */
    @Test
    public void PublishSubjectTest() {
        PublishSubject<Integer> subject = PublishSubject.create();
        ObServerTest obServerTest=new ObServerTest();
        subject.onNext(1);
        subject.subscribe(System.out::println);
        subject.subscribe(obServerTest::test1);
        subject.onNext(2);
        subject.onNext(3);
        subject.onNext(4);
    }

    /**
     * 会为每个订阅者重复发送之前的消息（可以设置size和timeout）
     */
    @Test
    public void ReplaySubjectTest() {
        ReplaySubject<Integer> subject = ReplaySubject.create();
        ObServerTest obServerTest=new ObServerTest();
        subject.onNext(1);
        subject.subscribe(v->System.out.println(v));
        subject.onNext(2);
        subject.onNext(3);
        subject.onNext(4);
        subject.subscribe(obServerTest::test1);
    }
    static class ObServerTest{
        public void test1(Object o){
            System.out.println("收到一个消息"+o);
        }

    }
}

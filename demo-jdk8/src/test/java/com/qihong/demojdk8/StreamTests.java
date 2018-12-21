package com.qihong.demojdk8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTests {

    @Test
    public void steamTests(){
        List<Student>students=new ArrayList<>();
        students.add(new Student("小王",16));
        students.add(new Student("小张",18));
        List<String>names=students
                .stream()
                .map(student->{return student.getName();})
                .collect(Collectors.toList());
        System.out.println(names);
    }
    class Student{
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}

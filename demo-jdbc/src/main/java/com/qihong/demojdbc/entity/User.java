package com.qihong.demojdbc.entity;

import javax.persistence.*;

@Entity
public class User {
    @Column
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;
    @Column
    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
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

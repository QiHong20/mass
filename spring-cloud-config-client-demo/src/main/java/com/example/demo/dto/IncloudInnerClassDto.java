package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IncloudInnerClassDto {

    @JsonProperty("XXX")
    private String xxx;
    @JsonProperty("INNER")
    private Inner inner=new Inner();
    public class Inner {
        @JsonProperty("NAME")
        private String name;
        @JsonProperty("AGE")
        private int age;

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

    public String getXxx() {
        return xxx;
    }

    public void setXxx(String xxx) {
        this.xxx = xxx;
    }

    public Inner getInner() {
        return inner;
    }

    public void setInner(Inner inner) {
        this.inner = inner;
    }
}

package com.example.demomassdata.config;

public class ErrorResult {
    private int code;
    private String message;

    @Override
    public String toString() {
        return "ErrorResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

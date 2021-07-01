package com.example.milestone1.entity;

import java.io.Serializable;

public class BaseResponse<T> implements Serializable {
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_FAIL = -1;
    public static final String MSG_SUCCESS = "success";
    public static final String MSG_FAIL = "fail";

    private int code;

    private String message;

    private T data;

    public BaseResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}

package com.example.milestone1.constants;

import org.springframework.http.HttpStatus;

public enum ResponseCode {
    SUCCESS(HttpStatus.OK,"success"),
    RESOURCE_NOT_EXIST(HttpStatus.NOT_FOUND,"Resource does not exist"),
    SERVICE_ERROR (HttpStatus.INTERNAL_SERVER_ERROR, "Server Exception"),
    CONFLICT(HttpStatus.CONFLICT,"Resource already exist");

    private HttpStatus code;
    private String msg;

    ResponseCode(HttpStatus code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public void setCode(HttpStatus code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public HttpStatus getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

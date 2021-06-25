package com.example.milestone1.common;

import com.example.milestone1.constants.ResponseCode;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class BaseResponse<T> implements Serializable {

    private HttpStatus code;
    private String message;
    private T data;

    public BaseResponse(Builder<T> builder) {
        this.code = builder.code;
        this.message = builder.message;
        this.data = builder.data;
    }

    public static Builder ok() {
        return new Builder().code(ResponseCode.SUCCESS.getCode()).message(ResponseCode.SUCCESS.getMsg());
    }

    public static <T> Builder ok(T t) {
        return new Builder().code(ResponseCode.SUCCESS.getCode()).message(ResponseCode.SUCCESS.getMsg()).data(t);
    }

    public static Builder error() {
        return new Builder().code(ResponseCode.SERVICE_ERROR.getCode()).message(ResponseCode.SERVICE_ERROR.getMsg());
    }

    public static  class Builder<T> {

        private HttpStatus code;
        private String message;
        private T data;

        public Builder code(HttpStatus code) {
            this.code = code;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder data(T data) {
            this.data = data;
            return this;
        }

        public  Builder success(){
            this.code = ResponseCode.SUCCESS.getCode();
            this.message = ResponseCode.SUCCESS.getMsg();
            return this;
        }

        public Builder fail() {
            this.code = ResponseCode.SERVICE_ERROR.getCode();
            this.message = ResponseCode.SERVICE_ERROR.getMsg();
            return this;
        }


        public BaseResponse build() {
            return new BaseResponse(this);
        }

    }
}

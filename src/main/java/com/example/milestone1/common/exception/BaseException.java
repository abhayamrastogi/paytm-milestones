package com.example.milestone1.common.exception;

import com.example.milestone1.constants.ResponseCode;

public class BaseException extends RuntimeException {

    private ResponseCode code;

    public BaseException(ResponseCode code) {
        this.code = code;
    }

    public BaseException(Throwable cause, ResponseCode code){
        super(cause);
        this.code = code;
    }

    public ResponseCode getCode() {
        return code;
    }
}

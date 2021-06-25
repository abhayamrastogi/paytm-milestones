package com.example.milestone1.error;

import com.example.milestone1.common.exception.BaseException;
import com.example.milestone1.constants.ResponseCode;

public class UnauthorizedException extends BaseException {

    public UnauthorizedException(ResponseCode code) {
        super(code);
    }

    public UnauthorizedException(Throwable cause, ResponseCode code) {
        super(cause, code);
    }
}

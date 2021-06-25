package com.example.milestone1.error;

import com.example.milestone1.common.exception.BaseException;
import com.example.milestone1.constants.ResponseCode;

public class UserNotFoundException extends BaseException {
    public UserNotFoundException(ResponseCode code) {
        super(code);
    }

    public UserNotFoundException(Throwable cause, ResponseCode code) {
        super(cause, code);
    }
}

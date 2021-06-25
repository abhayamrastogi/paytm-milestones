package com.example.milestone1.error;

import com.example.milestone1.common.exception.BaseException;
import com.example.milestone1.constants.ResponseCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserAlreadyExistException extends BaseException {

    public UserAlreadyExistException(ResponseCode code) {
        super(code);
    }

    public UserAlreadyExistException(Throwable cause, ResponseCode code) {
        super(cause, code);
    }
}

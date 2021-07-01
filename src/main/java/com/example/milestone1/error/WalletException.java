package com.example.milestone1.error;

import com.example.milestone1.common.exception.BaseException;
import com.example.milestone1.constants.ResponseCode;

public class WalletException extends BaseException {
    public WalletException(ResponseCode code) {
        super(code);
    }

    public WalletException(Throwable cause, ResponseCode code) {
        super(cause, code);
    }

}

package com.example.milestone1.common.exception;

import com.example.milestone1.common.BaseResponse;
import com.example.milestone1.constants.ResponseCode;
import com.example.milestone1.error.UserAlreadyExistException;
import org.apache.kafka.common.errors.SerializationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.support.serializer.DeserializationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(DeserializationException.class)
    public ResponseEntity<BaseResponse> handleException(DeserializationException e){
        log.error(e.getMessage(), e);
        BaseResponse exception = BaseResponse.error().build();
        return new ResponseEntity<>(exception, ResponseCode.SERVICE_ERROR.getCode());
    }

    @ExceptionHandler(SerializationException.class)
    public ResponseEntity<BaseResponse> handleException(SerializationException e){
        log.error(e.getMessage(), e);
        BaseResponse exception = BaseResponse.error().build();
        return new ResponseEntity<>(exception, ResponseCode.SERVICE_ERROR.getCode());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse> handleException(Exception e){
        log.error(e.getMessage(), e);
        BaseResponse exception = BaseResponse.error().build();
        return new ResponseEntity<>(exception, ResponseCode.SUCCESS.getCode());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<BaseResponse> handleRuntimeException(RuntimeException e){
        log.error(e.getMessage(), e);
        BaseResponse exception = BaseResponse.error().build();
        return new ResponseEntity<>(exception, ResponseCode.SERVICE_ERROR.getCode());
    }

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<BaseResponse> handleBaseException(BaseException e){
        log.error(e.getMessage(), e);
        ResponseCode responseCode = e.getCode();
        BaseResponse.Builder builder = new BaseResponse.Builder();
        builder.code(responseCode.getCode());
        builder.message(responseCode.getMsg());
        return new ResponseEntity<>(builder.build(), responseCode.getCode());
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public  ResponseEntity<BaseResponse> handleUserAlreadyExistException(UserAlreadyExistException e){
        log.info(e.getMessage());
        log.error(e.getMessage(), e);
        ResponseCode responseCode = e.getCode();
        BaseResponse.Builder builder = new BaseResponse.Builder();
        builder.code(responseCode.getCode());
        builder.message(responseCode.getMsg());
        return new ResponseEntity<>(builder.build(), responseCode.getCode());
    }
}

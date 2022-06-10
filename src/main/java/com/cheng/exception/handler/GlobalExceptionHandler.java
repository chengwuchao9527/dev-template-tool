package com.cheng.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author chengwuchao
 * @date 2022/6/10
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleException(Throwable e){
        log.error(Throwable);
        return buildResponseEntity(ApiError.error(e.getMessage()));
    }

    private ResponseEntity<ApiError> buildResponseEntity(ApiError apiError){
        return new ResponseEntity<>(apiError, HttpStatus.valueOf(apiError.getStatus()));
    }
}

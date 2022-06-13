package com.cheng.exception.handler;

import com.cheng.exception.BadRequestException;
import com.cheng.exception.EntityExistException;
import com.cheng.util.ThrowableUtil;
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

    /**
     * 处理所有未知异常
     * @param e 未知异常
     * @return  异常VO
     */
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ApiError> handleException(Throwable e){
        log.error(ThrowableUtil.getStackTrace(e));
        return buildResponseEntity(ApiError.error(e.getMessage()));
    }

    /**
     * 处理自定义异常
     * @param e 自定义异常
     * @return 异常VO
     */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError> handleException(BadRequestException e){
        //打印堆栈信息
        log.error(ThrowableUtil.getStackTrace(e));
        return buildResponseEntity(ApiError.error(e.getStatus(), e.getMessage()));
    }


    @ExceptionHandler(EntityExistException.class)
    public ResponseEntity<ApiError> handleException(EntityExistException e){
        //打印堆栈信息
        log.error(ThrowableUtil.getStackTrace(e));
        return buildResponseEntity(ApiError.error(e.getMessage()));
    }

    private ResponseEntity<ApiError> buildResponseEntity(ApiError apiError){
        return new ResponseEntity<>(apiError, HttpStatus.valueOf(apiError.getStatus()));
    }


}

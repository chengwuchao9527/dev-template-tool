package com.cheng.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author chengwuchao
 * @date 2022/6/10
 */
@Getter
public class BadRequestException extends RuntimeException{

    private Integer status = HttpStatus.BAD_REQUEST.value();

    public BadRequestException(String msg){
        super(msg);
    }

    public BadRequestException(HttpStatus status, String msg){
        super(msg);
        this.status = status.value();
    }

}

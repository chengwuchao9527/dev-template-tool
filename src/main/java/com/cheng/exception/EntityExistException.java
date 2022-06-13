package com.cheng.exception;

import org.springframework.util.StringUtils;

/**
 * 表数据异常处理类
 * @author chengwuchao
 * @date 2022/6/13
 */
public class EntityExistException extends RuntimeException{

    public EntityExistException(Class clazz, String field, String val){
        super();
    }

    private String generateMessage(String entity, String field, String val){
        return StringUtils.capitalize(entity) + "with" + field + " " + val + "existed";
    }
}

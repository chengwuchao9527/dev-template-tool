package com.cheng.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chengwuchao
 * @date 2022/3/18
 */
@Data
public class User implements Serializable {

    private Long id;

    private String name;
}
